<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>卖家商品管理后台</title>
    <meta name="keywords" content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文"/>
    <meta name="description" content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- basic styles -->
    <link href="/sell/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/sell/assets/css/font-awesome.min.css"/>

    <!--[if IE 7]>
    <link rel="stylesheet" href="/sell/assets/css/f"/>
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"/>

    <!-- ace styles -->

    <link rel="stylesheet" href="/sell/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="/sell/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="/sell/assets/css/ace-skins.min.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="/sell/assets/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->

    <script src="/sell/assets/js/ace-extra.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="/sell/assets/js/html5shiv.js"></script>
    <script src="/sell/assets/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="icon-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="icon-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="icon-group"></i>
            </button>

            <button class="btn btn-danger">
                <i class="icon-cogs"></i>
            </button>
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- #sidebar-shortcuts -->

    <ul class="nav nav-list">
        <li>
            <a href="/sell/seller/order/list">
                <i class="icon-dashboard"></i>
                <span class="menu-text"> 订单 </span>
            </a>
        </li>

        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-tag"></i>
                <span class="menu-text"> 商品 </span>
                <b class="arrow icon-angle-down"></b>
            </a>
            <ul class="submenu">
                <li>
                    <a href="/sell/seller/product/list">
                        <i class="icon-double-angle-right"></i>
                        餐品管理
                    </a>
                </li>
                <li>
                    <a href="/sell/seller/cproduct/list">
                        <i class="icon-double-angle-right"></i>
                        衣物清洗管理
                    </a>
                </li>
                <li>
                    <a href="/sell/seller/product/modify">
                        <i class="icon-double-angle-right"></i>
                        餐品上传
                    </a>
                </li>
                <li>
                    <a href="/sell/seller/cproduct/modify">
                        <i class="icon-double-angle-right"></i>
                        衣物上传
                    </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-tag"></i>
                <span class="menu-text"> 类目 </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
                <li>
                    <a href="/sell/seller/category/list">
                        <i class="icon-double-angle-right"></i>
                        餐品类目
                    </a>
                </li>
                <li>
                    <a href="/sell/seller/category/clist">
                        <i class="icon-double-angle-right"></i>
                        衣物类目
                    </a>
                </li>
                <li>
                    <a href="/sell/seller/category/modify">
                        <i class="icon-double-angle-right"></i>
                        餐品类目新增
                    </a>
                </li>
                <li>
                    <a href="/sell/seller/category/cmodify">
                        <i class="icon-double-angle-right"></i>
                        衣物类目新增
                    </a>
                </li>

            </ul>
        </li>

    </ul><!-- /.nav-list -->

    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
           data-icon2="icon-double-angle-right"></i>
    </div>

    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>

</body>
</html>