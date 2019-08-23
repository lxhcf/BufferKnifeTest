# BufferKnifeTest
该demo模拟第三方库butterKnife来实现View注入框架,使代码结构更清晰
# 实现效果
## 原来想再Acitivity中找到指定id的控件,需要这样做

    TextView textView=(TextView)findViewById(R.id.distract);
## 通过注解和反射后可以实现
    @BindView(R.id.distract)
    TextView textview;
此外,还对布局文件,和单机事件做了注入,给定一个资源文件,通过注解自动绑定到相应控件.
