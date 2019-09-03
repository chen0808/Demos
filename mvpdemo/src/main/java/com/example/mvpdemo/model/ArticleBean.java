package com.example.mvpdemo.model;

import java.util.List;

/**
 * 作者：陈飞
 * 时间：2019/08/28 15:40
 */
public class ArticleBean<T> {

    /**
     * curPage : 2
     * datas : [{"apkLink":"","author":"androad","chapterId":200,"chapterName":"https","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9013,"link":"https://juejin.im/post/5d5e5cd8f265da03cc08c1e1","niceDate":"2019-08-23","origin":"","prefix":"","projectLink":"","publishTime":1566494586000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"Android网络编程-HTTP/HTTPS","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"猩程变","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9012,"link":"https://juejin.im/post/5d5e6c48f265da03bf0f4953","niceDate":"2019-08-23","origin":"","prefix":"","projectLink":"","publishTime":1566494513000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"再探Gradle","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9036,"link":"https://mp.weixin.qq.com/s/kjHK37nKgwysBUS2gT_QjQ","niceDate":"2019-08-23","origin":"","prefix":"","projectLink":"","publishTime":1566489600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"走心推荐几个优质项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9042,"link":"https://mp.weixin.qq.com/s/SyAyaWOI7WowdoXUVBcnmg","niceDate":"2019-08-23","origin":"","prefix":"","projectLink":"","publishTime":1566489600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"在 JVM 眼中 .class 文件是什么样的？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"玉刚说","chapterId":410,"chapterName":"玉刚说","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9046,"link":"https://mp.weixin.qq.com/s/uDj-wa3j6crA8mpsoTzmfQ","niceDate":"2019-08-23","origin":"","prefix":"","projectLink":"","publishTime":1566489600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/410/1"}],"title":"RecyclerView 实现吸底效果，这个必须要会啊","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9054,"link":"https://mp.weixin.qq.com/s/fcmQyT5nCvEYLVeSgQUiRA","niceDate":"2019-08-23","origin":"","prefix":"","projectLink":"","publishTime":1566489600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"Android 应用广告过滤几种方式","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":360,"chapterName":"小编发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9011,"link":"https://www.wanandroid.com/blog/show/2659","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406686000,"superChapterId":298,"superChapterName":"原创文章","tags":[],"title":"为了感谢经常访问的同学，我们上线了积分机制","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"连理枝__","chapterId":245,"chapterName":"集合相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9010,"link":"https://www.jianshu.com/p/95907802e10b","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406567000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"面试官：&ldquo;你重写过 hashcode 和 equals 么，为什么重写equals时必须重写hashCode方法？&rdquo;","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 的一幕","chapterId":99,"chapterName":"具体案例","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9009,"link":"https://www.jianshu.com/p/cf2169630f5e","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406544000,"superChapterId":99,"superChapterName":"自定义控件","tags":[],"title":"一分钟搞定触手app主页酷炫滑动切换效果","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"波波维奇c","chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9008,"link":"https://www.jianshu.com/p/5d0a1879fd6f","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406520000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"View.Post () 的身世大揭秘","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"lovesosoi","chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9007,"link":"https://www.jianshu.com/p/c0e00bca6cba","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406490000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"Android 如何更优雅的打Log","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"MxsQ","chapterId":346,"chapterName":"JVM","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9006,"link":"https://www.jianshu.com/p/92dc4f16cfc5","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406464000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"JVM 方法到底如何执行","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 爱情小傻蛋 ","chapterId":308,"chapterName":"多线程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9005,"link":"https://www.jianshu.com/p/543d438c67e9","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406444000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"同步屏障CyclicBarrier的实现原理","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"JohnnyShieh","chapterId":227,"chapterName":"注解","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9004,"link":"https://www.jianshu.com/p/d32a2453786e","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406420000,"superChapterId":227,"superChapterName":"注解 & 反射 & AOP","tags":[],"title":"AspectJ in Android （三），AspectJ 两种用法以及常见问题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9035,"link":"https://mp.weixin.qq.com/s/WTlC5DoODDUGGoI67Ze8vw","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566403200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"我为什么要手撸一个简易版ARouter","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"玉刚说","chapterId":410,"chapterName":"玉刚说","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9045,"link":"https://mp.weixin.qq.com/s/Cx0IqXGvk-aHwdfOgGs1Kg","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566403200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/410/1"}],"title":"到底怎样写 try-catch，才能称之为高手？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Android群英传","chapterId":413,"chapterName":"Android群英传","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9050,"link":"https://mp.weixin.qq.com/s/UFPCURIGE-eTgr8xEAueHQ","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566403200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/413/1"}],"title":"模拟自然动画的精髓&mdash;&mdash;TimeInterpolator与TypeEvaluator","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"灯不利多","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9003,"link":"https://juejin.im/post/5d5aa36af265da03963b9913","niceDate":"2019-08-21","origin":"","prefix":"","projectLink":"","publishTime":1566319394000,"superChapterId":185,"superChapterName":"热门专题","tags":[],"title":"探索 Android 启动优化方法","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"程序亦非猿","chapterId":428,"chapterName":"程序亦非猿","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9029,"link":"https://mp.weixin.qq.com/s/oAZWeZEIbgnYQELJwtW7ZA","niceDate":"2019-08-21","origin":"","prefix":"","projectLink":"","publishTime":1566316800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/428/1"}],"title":"【连载】聊聊 APK（四） &mdash;&mdash; 脱离 AS 手工创造 APK 文件","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9034,"link":"https://mp.weixin.qq.com/s/wyN6I4KTNWI-VE3KbjtgUQ","niceDate":"2019-08-21","origin":"","prefix":"","projectLink":"","publishTime":1566316800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"9102年了，还不知道Android为什么卡？","type":0,"userId":-1,"visible":1,"zan":0}]
     * offset : 20
     * over : false
     * pageCount : 353
     * size : 20
     * total : 7058
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<T> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
