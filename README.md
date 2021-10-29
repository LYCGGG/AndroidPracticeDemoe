# AndroidPracticeDemoe

存放我用来练习Android相关技术的Demo.都比较简单.

我又仔细研究了下，当前的目录分类没毛病。以DaggerDemo为例，它是一个Project，其Module在它的子目录中。当我们创建其他Project的时候，同样在上级目录下即可。

[TOC]

## 关键之补充说明

直接进行一个分析和结论的说明：

当前仓库的矛盾点在于我的想法是使用该仓库来存储练习过的Android Project Demo，依照Android Studio推荐的架构方式，**每一个Demo是一个Project**而非当作Moudle。然而Android Studio也内置了Git管理工具，但是它是以Project为仓库进行管理的。

解决办法是引入SourceTree这一个可视化的Git管理工具，用来管理整个Demo仓库，而每个Project就在AS中打开并处理即可。当然AS中也可以Commit，但只是作为辅助。

## DaggerDemo

学习Dagger注入技术所练习的demo，受限于gitigonre,编译过程中生成的文件没有上传到GitHub，但是要想梳理清楚Dagger2技术下代码是如何调用的还真得看编译过程中生成的文件。

### Dagger是干嘛用的

经过我近一周的研究(抓虾)，终于搞懂了Dagger最基础的使用方法以及这是要做什么。

假设有两个类

``` java
public class TestA {
    public TestA(){
    }
}

public class A{
    public A(){}
}
```

TestA要使用A，那么可以这么做的。

``` java
public class TestA{
    A a;
    public TestA(A a){
        this.a = a;
        // 或者使用接口、再或者放到别的位置初始化也好
        a.doSth;// 然后就可以调用A的方法
    }
}
```

从最基础的使用角度来说，Dagger就是使用另一种方法完成同样的功能。如果使用Dagger完成，那么应该是这样的：

``` java
public class TestA{
    @Inject
    A a;
    public TestA(){
        DaggerXXXComponent.builder().build().test(this);
        // 上面这行就相当于初始化
        a.doSth;
    }
}
```

在这其中，DaggerXXXComponent就是起到一个桥梁作用，并且它还是由系统自动生成(借助于XXXComponent)。

### Provide起到的作用

上面说的是Inject和Component的作用，但Provider又起到什么作用呢？

其实无论是Provides还是下面会提到的Binds都是起到一个说明绑定的作用，实际上我们既不用调用这些个方法来手动实现绑定或者说类的提供。而与Binds不同的是，Provides是需要提供具体方法的。

### @Binds

这玩意搞了好久才懂，没想到真没有方法会调用到Module中的绑定方法，而这个注解只是起到一个说明作用。我也是醉了。

### @Component && @Subcomponent

简单来说，@Component需要指明Component所依赖的Component，而Subcomponent是不太关心这点的。

实际操作是(仅文字论述):有一个Module中写了两个方法表明提供两个依赖，然后有个Component指明该Module但是指提供了获取其中一个依赖的方法。然后再使用一个Component添加对前Component的依赖。注入之后就会发现，提供了获取方法的依赖是可以获取的(好™拗口，而且是废话，但事实确实如此)。如果想要获取另一个依赖，那么就要添加对应的方法，或者使用Subcomponent。

对于Subcomponet，操作是在Component中直接说明依赖关系。

而二者的差别可以用StackFlow中的一个回答来说明:

> Component Dependencies - Use this when:
>
>    you want to keep two components independent.
>    you want to explicitly show what dependencies from one component is used by the other.
>
> Subcomponents - Use this when:
>
>    you want to keep two component cohesive.
>    you may not care to explicitly show what dependencies from one component is used by the other.

简单来说，如果你想要保证两个Component相互独立，那就使用Component+dependencies的方式来说明，而如果想要两者内聚(cohesive),但又不关心哪个component依赖于哪个component，那么就使用Subcomponent.

具体是使用方法请看代码。

## PreferenceDemo

这个Demo是用来学习Perference作为Activity时的一些简单用法，以及一些常用的Perference，它经常被用于系统应用中，但是第三方使用时似乎是不推荐的。

其实它应该是比一般的Activity简单的，但是简单也会有问题。

针对一些Preference进行了测试，发现其中的复杂点在于自定义的Preference，其中最烦的是自定义的EditPreference。从方法来说，EditPreference给出了不少可以复写的方法，然而这些方法并没有提高很高的自由度。
具体来说，很多关键的参数和变量都是private,因此复写不如重写，既然都重写，我继承你这个类还有什么意义呢？

#### CustomEditPreference

单开一小节来介绍自定义的EditPreference.首先，它涉及到两个layout,即未点击时的Preference和点击后的弹框带Edit的Dialog。如果没有自定义的话，正常的流程是这样的：在构造时，会将Android包中的写好的一个id传过来，在点击时会传递这个id，并创建一个常规的AlertDialog.

``` java
    protected void showDialog(Bundle state) {
        Context context = getContext();

        mWhichButtonClicked = DialogInterface.BUTTON_NEGATIVE;

        mBuilder = new AlertDialog.Builder(context)
            .setTitle(mDialogTitle)
            .setIcon(mDialogIcon)
            .setPositiveButton(mPositiveButtonText, this)
            .setNegativeButton(mNegativeButtonText, this);

        View contentView = onCreateDialogView();
        if (contentView != null) {
            onBindDialogView(contentView);
            mBuilder.setView(contentView);
        } else {
            mBuilder.setMessage(mDialogMessage);
        }

        onPrepareDialogBuilder(mBuilder);

        getPreferenceManager().registerOnActivityDestroyListener(this);

        // Create the dialog
        final Dialog dialog = mDialog = mBuilder.create();
        if (state != null) {
            dialog.onRestoreInstanceState(state);
        }
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                removeDismissCallbacks();
            }
        });
        dialog.setOnDismissListener(this);
        dialog.show();
    }
```

onClick() -> showDialog(null) -> 1.mBuilder创建 2.onCreateDialogView 3.onBindDialogView 4.mBuilder.create() 5.dialog.show -> over

那么涉及到的方法有:
* onClick:可以设置Bundle,传递给showDialog.
* showDialog：可变的东西不多，关键的mBuilder不能改。
* onCreateDialogView:就是根据构造时传递的layout_id创建布局，mBuidler和inflater同样无法修改
* onBindDialogView: 从代码来看目前没有改动的需求

怎么改动？能怎么改动？首先构造时使用我们自定义的Layout_Id,覆盖掉默认的。但是问题是有个方法叫getEditText,它得到的是默认的Edit，如果我们使用我们自己的Edit,那么就无法通过getEditText得到，也无法直接得到输入的文本，那么又要进行复写。那么怎么做呢？还是复写，那就没什么意义了。

麻烦！其实也不是这个控件的问题，它的很多方法是protected的，就不该复写。

目前给出的和能想到的方法就是在layout中添加一个布局，然后在onAddEditTextToDialogView中把系统的editText添加到view中。