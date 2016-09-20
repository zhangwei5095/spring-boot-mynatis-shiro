<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="./commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            $(document).ready(function() {
            })
        </script>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-3">
                <div class="well">
                    个人账号信息
                </div>

                <div class="well">
                    资讯
                </div>

                <div class="well">
                    动态
                </div>
            </div>
            <div class="col-lg-6">
                <div class="home-carousel clearfix">
                    <div data-ride="carousel" class="carousel slide">
                        <ol class="carousel-indicators">
                            <li data-slide-to="0" data-target="#carousel-example-generic" class="active"></li>
                            <li data-slide-to="1" data-target="#carousel-example-generic"></li>
                            <li data-slide-to="2" data-target="#carousel-example-generic"></li>
                        </ol>
                        <div role="listbox" class="carousel-inner">
                            <div class="item">
                                <img alt="First slide [450x250]"
                                     data-src="holder.js/450x250/auto/#777:#555/text:First slide"
                                     src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iOTAwIiBoZWlnaHQ9IjUwMCIgdmlld0JveD0iMCAwIDkwMCA1MDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzkwMHg1MDAvYXV0by8jNzc3OiM1NTUvdGV4dDpGaXJzdCBzbGlkZQpDcmVhdGVkIHdpdGggSG9sZGVyLmpzIDIuNi4wLgpMZWFybiBtb3JlIGF0IGh0dHA6Ly9ob2xkZXJqcy5jb20KKGMpIDIwMTItMjAxNSBJdmFuIE1hbG9waW5za3kgLSBodHRwOi8vaW1za3kuY28KLS0+PGRlZnM+PHN0eWxlIHR5cGU9InRleHQvY3NzIj48IVtDREFUQVsjaG9sZGVyXzE1NDk4OTI1ZjM1IHRleHQgeyBmaWxsOiM1NTU7Zm9udC13ZWlnaHQ6Ym9sZDtmb250LWZhbWlseTpBcmlhbCwgSGVsdmV0aWNhLCBPcGVuIFNhbnMsIHNhbnMtc2VyaWYsIG1vbm9zcGFjZTtmb250LXNpemU6NDVwdCB9IF1dPjwvc3R5bGU+PC9kZWZzPjxnIGlkPSJob2xkZXJfMTU0OTg5MjVmMzUiPjxyZWN0IHdpZHRoPSI5MDAiIGhlaWdodD0iNTAwIiBmaWxsPSIjNzc3Ii8+PGc+PHRleHQgeD0iMzA3LjgwMDAwMzA1MTc1NzgiIHk9IjI3MC4yNSI+Rmlyc3Qgc2xpZGU8L3RleHQ+PC9nPjwvZz48L3N2Zz4="
                                     data-holder-rendered="true">
                            </div>
                            <div class="item active">
                                <img alt="Second slide [450x250]"
                                     data-src="holder.js/450x250/auto/#666:#444/text:Second slide"
                                     src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iOTAwIiBoZWlnaHQ9IjUwMCIgdmlld0JveD0iMCAwIDkwMCA1MDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzkwMHg1MDAvYXV0by8jNjY2OiM0NDQvdGV4dDpTZWNvbmQgc2xpZGUKQ3JlYXRlZCB3aXRoIEhvbGRlci5qcyAyLjYuMC4KTGVhcm4gbW9yZSBhdCBodHRwOi8vaG9sZGVyanMuY29tCihjKSAyMDEyLTIwMTUgSXZhbiBNYWxvcGluc2t5IC0gaHR0cDovL2ltc2t5LmNvCi0tPjxkZWZzPjxzdHlsZSB0eXBlPSJ0ZXh0L2NzcyI+PCFbQ0RBVEFbI2hvbGRlcl8xNTQ5ODkyMzJjMiB0ZXh0IHsgZmlsbDojNDQ0O2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjQ1cHQgfSBdXT48L3N0eWxlPjwvZGVmcz48ZyBpZD0iaG9sZGVyXzE1NDk4OTIzMmMyIj48cmVjdCB3aWR0aD0iOTAwIiBoZWlnaHQ9IjUwMCIgZmlsbD0iIzY2NiIvPjxnPjx0ZXh0IHg9IjI2NC40NTgzMjgyNDcwNzAzIiB5PSIyNzAuMjUiPlNlY29uZCBzbGlkZTwvdGV4dD48L2c+PC9nPjwvc3ZnPg=="
                                     data-holder-rendered="true"></div>
                            <div class="item">
                                <img alt="Third slide [450x250]"
                                     data-src="holder.js/450x250/auto/#555:#333/text:Third slide"
                                     src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iOTAwIiBoZWlnaHQ9IjUwMCIgdmlld0JveD0iMCAwIDkwMCA1MDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzkwMHg1MDAvYXV0by8jNTU1OiMzMzMvdGV4dDpUaGlyZCBzbGlkZQpDcmVhdGVkIHdpdGggSG9sZGVyLmpzIDIuNi4wLgpMZWFybiBtb3JlIGF0IGh0dHA6Ly9ob2xkZXJqcy5jb20KKGMpIDIwMTItMjAxNSBJdmFuIE1hbG9waW5za3kgLSBodHRwOi8vaW1za3kuY28KLS0+PGRlZnM+PHN0eWxlIHR5cGU9InRleHQvY3NzIj48IVtDREFUQVsjaG9sZGVyXzE1NDk4OTIxNzVmIHRleHQgeyBmaWxsOiMzMzM7Zm9udC13ZWlnaHQ6Ym9sZDtmb250LWZhbWlseTpBcmlhbCwgSGVsdmV0aWNhLCBPcGVuIFNhbnMsIHNhbnMtc2VyaWYsIG1vbm9zcGFjZTtmb250LXNpemU6NDVwdCB9IF1dPjwvc3R5bGU+PC9kZWZzPjxnIGlkPSJob2xkZXJfMTU0OTg5MjE3NWYiPjxyZWN0IHdpZHRoPSI5MDAiIGhlaWdodD0iNTAwIiBmaWxsPSIjNTU1Ii8+PGc+PHRleHQgeD0iMjk3LjgyNDk5Njk0ODI0MjIiIHk9IjI3MC4yNSI+VGhpcmQgc2xpZGU8L3RleHQ+PC9nPjwvZz48L3N2Zz4="
                                     data-holder-rendered="true"></div>
                        </div>
                    </div>
                </div>

                <div class="well">
                    <div data-example-id="togglable-tabs" class="bs-example bs-example-tabs">
                        <ul role="tablist" class="nav nav-tabs" id="myTabs">
                            <li class="active" role="presentation">
                                <a aria-expanded="true" aria-controls="home"
                                   data-toggle="tab" role="tab" id="home-tab" href="#home">进行中</a>
                            </li>
                            <li role="presentation" class="">
                                <a aria-controls="profile" data-toggle="tab"
                                   id="profile-tab" role="tab" href="#profile" aria-expanded="false">已完成</a>
                            </li>
                            <li class="dropdown" role="presentation">
                                <a aria-controls="myTabDrop1-contents"
                                                                        data-toggle="dropdown" class="dropdown-toggle"
                                                                        id="myTabDrop1" href="#" aria-expanded="false">Dropdown
                                <span class="caret"></span></a>
                                <ul id="myTabDrop1-contents" aria-labelledby="myTabDrop1" class="dropdown-menu">
                                    <li><a aria-controls="dropdown1" data-toggle="tab" id="dropdown1-tab" role="tab"
                                           href="#dropdown1" aria-expanded="false">@fat</a></li>
                                    <li class=""><a aria-controls="dropdown2" data-toggle="tab" id="dropdown2-tab"
                                                    role="tab" href="#dropdown2" aria-expanded="false">@mdo</a></li>
                                </ul>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div aria-labelledby="home-tab" id="home" class="tab-pane fade active in" role="tabpanel">
                                <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu
                                    stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg
                                    carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth.
                                    Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat
                                    salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher
                                    voluptate nisi qui.</p></div>
                            <div aria-labelledby="profile-tab" id="profile" class="tab-pane fade" role="tabpanel"><p>
                                Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid.
                                Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson
                                artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo
                                enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud
                                organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia
                                yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes
                                anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson
                                biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente
                                accusamus tattooed echo park.</p></div>
                            <div aria-labelledby="dropdown1-tab" id="dropdown1" class="tab-pane fade" role="tabpanel">
                                <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's
                                    organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify
                                    pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy
                                    hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred
                                    pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel
                                    fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of
                                    them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray
                                    yr.</p></div>
                            <div aria-labelledby="dropdown2-tab" id="dropdown2" class="tab-pane fade" role="tabpanel">
                                <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they
                                    sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny
                                    pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin.
                                    Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS
                                    viral locavore cosby sweater. Lomo wolf viral, mustache readymade thundercats
                                    keffiyeh craft beer marfa ethical. Wolf salvia freegan, sartorial keffiyeh echo park
                                    vegan.</p></div>
                        </div>
                    </div>
                </div>

                <div class="well">
                    我的考试
                </div>
            </div>
            <div class="col-lg-3">
                <div class="well">
                    调查问卷
                </div>

                <div class="well">
                    积分排行榜
                </div>

                <div class="well">
                    问答
                </div>
            </div>
        </div>
    </body>
</html>
