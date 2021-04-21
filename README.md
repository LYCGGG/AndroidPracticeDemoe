# AndroidPracticeDemoe

存放我用来练习Android相关技术的Demo.都比较简单.

我又仔细研究了下，当前的目录分类没毛病。以DaggerDemo为例，它是一个Project，其Module在它的子目录中。当我们创建其他Project的时候，同样在上级目录下即可。

[TOC]

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

对于Subcomponet，操作是在Component中直接提供即可。

待更新。。。

具体是使用方法请看代码。