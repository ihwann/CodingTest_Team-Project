
<!DOCTYPE html>
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

<meta charset="utf-8">
<title>알고리즘 연습 - 조이스틱 | 프로그래머스</title>
<link rel="shortcut icon" type="image/x-icon" href="https://programmers.co.kr/assets/icons/favicon-40b78633b6556a68c3da8e2125c31512fbd01d09906ab76c8a8ff289e494cadb.png">
<link rel="apple-touch-icon" type="image/png" href="https://programmers.co.kr/assets/icons/apple-icon-6eafc2c4c58a21aef692d6e44ce99d41f999c71789f277317532d0a9c6db8976.png">
<meta name="keywords" content="코딩 교육, 코딩, 프로그래밍, 실습, 생활코딩, 알고리즘, cpp">
<meta property="fb:app_id" content="339079816467879">
<meta name="twitter:title" property="og:title" itemprop="title name" content="알고리즘 연습 - 조이스틱 | 프로그래머스">
<meta name="twitter:image" property="og:image" itemprop="image primaryImageOfPage" content="https://image.freepik.com/free-vector/landing-page-template-for-a-website_23-2147782747.jpg">
<meta name="twitter:url" property="og:url" content="https://programmers.co.kr/learn/courses/30/lessons/42860">
<meta property="og:type" content="website">
<meta property="og:site_name" content="프로그래머스">
<meta property="og:locale" content="ko_KR">
<meta name="twitter:card" content="summary">

<style>

body {
    width: 100%;
    margin: 0;
    word-break: keep-all;
    word-wrap: break-word;
    color: #263747;
}
body {
    font-family: "roboto", 'NotoSansKR', "Helvetica Neue", Helvetica, Arial, "맑은 고딕", malgun gothic, "돋움", Dotum, sans-serif;
    font-size: 16px;
    line-height: 24px;
    color: #263747;
    background-color: #ffffff;
}
body {
    margin: 0;
}
body {
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
    font-size: 1rem;
    line-height: 1.5;
    color: #373a3c;
    background-color: #fff;
}
body {
    margin: 0;
}
* {
    box-sizing: border-box;
}
*, *::before, *::after {
    box-sizing: inherit;
}
user agent stylesheet
body {
    display: block;
    margin: 8px;
}
html {
    font-size: 16px;
    -webkit-tap-highlight-color: transparent;
}
html {
    font-family: sans-serif;
    -ms-text-size-adjust: 100%;
    -webkit-text-size-adjust: 100%;
}
html {
    font-size: 16px;
    -ms-overflow-style: scrollbar;
    -webkit-tap-highlight-color: transparent;
}
html {
    font-family: sans-serif;
    line-height: 1.15;
    -ms-text-size-adjust: 100%;
    -webkit-text-size-adjust: 100%;
}
user agent stylesheet
html {
    color: -internal-root-color;
}
*:before, *:after {
    box-sizing: border-box;
}
*, *::before, *::after {
    box-sizing: inherit;
}
*:before, *:after {
    box-sizing: border-box;
}

*, *::before, *::after {
    box-sizing: inherit;
}

</style>
  <!-- Google Analytics -->
<script>
  (function (i, s, o, g, r, a, m) {
    i['GoogleAnalyticsObject'] = r;
    i[r] = i[r] || function () {
      (i[r].q = i[r].q || []).push(arguments)
    }, i[r].l = 1 * new Date();
    a = s.createElement(o),
      m = s.getElementsByTagName(o)[0];
    a.async = 1;
    a.src = g;
    m.parentNode.insertBefore(a, m)
  })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

  ga('create', 'UA-72680702-5', 'auto', {allowLinker: true, userId: 'Guest-9348912'});
  ga('linker:autoLink', ['programmers.co.kr', 'www.programmers.co.kr', 'business.programmers.co.kr']);
  ga('send', 'pageview');
</script>
<!-- End Google Analytics -->

  <!-- Facebook Pixel Code -->
<script>
  !function (f, b, e, v, n, t, s) {
    if (f.fbq) return;
    n = f.fbq = function () {
      n.callMethod ?
        n.callMethod.apply(n, arguments) : n.queue.push(arguments)
    };
    if (!f._fbq) f._fbq = n;
    n.push = n;
    n.loaded = !0;
    n.version = '2.0';
    n.queue = [];
    t = b.createElement(e);
    t.async = !0;
    t.src = v;
    s = b.getElementsByTagName(e)[0];
    s.parentNode.insertBefore(t, s)
  }(window, document, 'script',
    'https://connect.facebook.net/en_US/fbevents.js');
  fbq('init', '2050250308523590');
  fbq('track', 'PageView');
</script>
<noscript>
  <img height="1" width="1" style="display:none" src="https://www.facebook.com/tr?id=2050250308523590&ev=PageView&noscript=1"/>
</noscript>
<!-- End Facebook Pixel Code -->

  <!-- Google Tag Manager -->
<script>(function (w, d, s, l, i) {
  w[l] = w[l] || [];
  w[l].push({
    'gtm.start':
      new Date().getTime(), event: 'gtm.js'
  });
  var f = d.getElementsByTagName(s)[0],
    j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : '';
  j.async = true;
  j.src =
    'https://www.googletagmanager.com/gtm.js?id=' + i + dl;
  f.parentNode.insertBefore(j, f);
})(window, document, 'script', 'dataLayer', 'GTM-NMDXJHR');</script>
<noscript>
  <iframe src="https://www.googletagmanager.com/ns.html?id=GTM-NMDXJHR"
          height="0" width="0" style="display:none;visibility:hidden"></iframe>
</noscript>
<!-- End Google Tag Manager -->

  <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
        google_ad_client: "ca-pub-3622640291758278",
        enable_page_level_ads: true
    });
</script>


</head>
<body class="learn-lessons learn-lessons-show"
      data-ns="Learn"
      data-controller="lessons"
      data-action="show"
      data-defaultLocale="ko"
      data-locale="ko">



  <div class="navbar navbar-inverse navbar-application navbar-breadcrumb">
  <div class="navbar-header">
    <a class="navbar-brand" href="/">
        <img alt="logo" width="24" src="/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" />
</a>      <ol class="breadcrumb"><li><a href="https://programmers.co.kr/learn/challenges">코딩테스트 연습</a></li><li><a href="/learn/challenges?selected_part_id=12244">탐욕법(Greedy)</a></li><li class="active">조이스틱</li></ol>
  </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right navbar-account">
        <li><a onclick="Learn.lessons.challengeable.startTour(true)" id="help" href="#">도움말</a></li>
        <li><a data-remote="true" href="/compile_options">컴파일 옵션</a></li>
      </ul>
    </div>
</div>



<div class="main theme-dark">
  
  <div class="lesson-content"
       data-course-slug="알고리즘-연습"
       data-course-id="30"
       data-lesson-id="42860"
       data-lesson-type="Challenge"
       data-next-lesson-id="">

    
<ul class="challenge-nav nav nav-tabs nav-tabs-dark task-tab" id="tab" role="tablist">
  <li class="algorithm-nav-link algorithm-title">
    조이스틱
  </li>

  
<li class="challenge-settings nav-item pull-right">
  <div class="btn-group-theme btn-group" data-toggle="buttons">
      <label class="btn btn-md btn-dark-outline active">
        <input type="radio" name="themes" autocomplete="off" checked data-toggle="button" data-theme="dark">dark
      </label>
      <label class="btn btn-md btn-dark-outline ">
        <input type="radio" name="themes" autocomplete="off"  data-toggle="button" data-theme="light">light
      </label>
  </div>

    <div data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="코드 에디터의 단축키를 설정하는 옵션입니다. 선호하는 에디터 옵션이 없다면 sublime을 선택해 주세요.">
      <div class="btn-group-keymap btn-group" data-toggle="buttons">
          <label class="btn btn-md btn-dark-outline active">
            <input type="radio" name="keymaps" autocomplete="off" checked data-keymap="sublime">sublime
          </label>
          <label class="btn btn-md btn-dark-outline ">
            <input type="radio" name="keymaps" autocomplete="off"  data-keymap="vim">vim
          </label>
          <label class="btn btn-md btn-dark-outline ">
            <input type="radio" name="keymaps" autocomplete="off"  data-keymap="emacs">emacs
          </label>
      </div>
    </div>

    <div class="dropdown-language animated-dropdown" id="tour7">
      <button class="btn btn-md btn-dark dropdown-toggle" type="button" data-toggle="dropdown">
        C++
      </button>
        <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
          <li>
              <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42860?language=cpp">C++</a>
              <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42860?language=csharp">C#</a>
              <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42860?language=go">Go</a>
              <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42860?language=java">Java</a>
              <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42860?language=javascript">JavaScript</a>
              <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42860?language=kotlin">Kotlin</a>
              <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42860?language=python">Python2</a>
              <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42860?language=python3">Python3</a>
              <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42860?language=ruby">Ruby</a>
              <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42860?language=scala">Scala</a>
              <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42860?language=swift">Swift</a>
          </li>
        </ul>
    </div>
</li>

</ul>

<div class="challenge-content lesson-algorithm-main-section  "
     data-challengeable-id="2578"
     data-challengeable-type="algorithm"
     data-algorithm-type="standard"
     data-language="cpp"
     data-user-id=""
     data-interface-type="function"
     data-challenge-web-evaluation-code="">
    

<div class="main-section">
  <div class="guide-section" id="tour2">
    <div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.<br>
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA</p>

<p>조이스틱을 각 방향으로 움직이면 아래와 같습니다.</p>
<div class="highlight"><pre class="codehilite"><code>▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동
</code></pre></div>
<p>예를 들어 아래의 방법으로 <q>JAZ</q>를 만들 수 있습니다.</p>
<div class="highlight"><pre class="codehilite"><code>- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
</code></pre></div>
<p>만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.</p>

<h5>제한 사항</h5>

<ul>
<li>name은 알파벳 대문자로만 이루어져 있습니다.</li>
<li>name의 길이는 1 이상 20 이하입니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>name</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td><q>JEROEN</q></td>
<td>56</td>
</tr>
<tr>
<td><q>JAN</q></td>
<td>23</td>
</tr>
</tbody>
      </table>
<p><a href="https://commissies.ch.tudelft.nl/chipcie/archief/2010/nwerc/nwerc2010.pdf" target="_blank">출처</a></p>

<p>※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.</p>
</div>
    </div>
  </div>
  <div class="run-section">
    <div id="tour3" class="code-section" onkeyup="Hera.tryoutChallenges.resizeEditor(this);">
      <div class="editor">
        <ul class="nav nav-pills editor-nav-pills tap-form">
    <input type="hidden" name="initial_code_7877" id="initial_code_7877" value="#include &lt;string&gt;
#include &lt;vector&gt;

using namespace std;

int solution(string name) {
    int answer = 0;
    return answer;
}" />
    <input id="7877"
           data-type="code"
           data-language="cpp"
           type="hidden"
           value="#include &lt;string&gt;
#include &lt;vector&gt;

using namespace std;

int solution(string name) {
    int answer = 0;
    return answer;
}"/>
    <li class="nav-item">
      <a href="#" class="btn-tab nav-link active"
         data-id="7877"
         data-language="cpp">
        solution.cpp </a>
    </li>
</ul>
        
          <textarea hidden id="code" name="code">#include &lt;string&gt;
#include &lt;vector&gt;

using namespace std;

int solution(string name) {
    int answer = 0;
    return answer;
}</textarea>
      </div>
    </div>

    <div class="output-section" id="tour6">
      <div class="tab-header">
        <div id="output-title" class="output-title" data-toggle="tab">
          <span class="connection-status disconnected"
                data-container="body" data-toggle="popover" data-placement="top" title="서버와의 연결 끊김" data-html="true"
                data-content="
                  <h6>네트워크가 불안정하여 서버와의 연결이 끊어졌습니다.
                  페이지 새로고침을 하거나 네트워크가 안정적이 되면 자동으로 재 연결됩니다.</h6>
                  <h6 style='margin-top: 4px;'>네트워크가 정상임에도 계속해서 연결이 끊어진 상태가 지속된다면 네트워크 방화벽 문제일 수 있습니다.
                  모바일 테더링 등 다른 네트워크를 통해 테스트에 접속해 보세요.</h6>">
            <svg class="ic-24"><use xlink:href="/assets/svg-defs-3f095936d4f7b63d2ea604fd0729d51861ab39e22177dc43f2544ad0a3570786.svg#ic-power-off"/></svg>
          </span>

          실행 결과
            <a id="stop-button" class="btn btn-sm btn-danger" href="#">실행 중지</a>
          <span id="output-spinner" class="spinner hidden">
              <span class="bounce1"></span>
              <span class="bounce2"></span>
              <span class="bounce3"></span>
            </span>
        </div>
      </div>
      <div class="console tab-content">
        <div id="output" class="console-output tab-pane fade in active">
          실행 결과가 여기에 표시됩니다.
        </div>
      </div>
    </div>
  </div>
</div>

<div class="button-section">
  <div class="testcase-button">
    <a id="btn-show-question" class="btn btn-dark" href="/learn/courses/30/lessons/42860/questions">질문하기 (9)</a>
      <a class="btn btn-dark btn-block" data-remote="true" href="/challenge_algorithms/2578/custom_testcases?lesson_id=42860">
        <div class="flex-normal flex-space-between">
          테스트 케이스 추가하기<svg class=""><use xlink:href="/assets/svg-defs-3f095936d4f7b63d2ea604fd0729d51861ab39e22177dc43f2544ad0a3570786.svg#ic-add"/></svg>
        </div>
</a>  </div>

  <div class="func-buttons">

      <a class="btn btn-primary" href="/users/login">로그인하기</a>
  </div>
</div>
</div>
  </div>

</div>



<div class="modal fade" id="modal-dialog" tabindex="-1" role="dialog" aria-hidden="true"></div>

<script src="/assets/application-ed1c07188e064d9b44780a8fa2014440554b66e2b3f28e8d8219d6dc0afb9a73.js"></script>

<script>
//<![CDATA[
  I18n.defaultLocale = "ko";
  I18n.locale = "ko";

//]]>
</script>
<script>
//<![CDATA[
window.addEventListener('load', function() {});
//]]>
</script>
  <script src="//widget.cloudinary.com/global/all.js" type="text/javascript">
    cloudinary.setCloudName('eightcruz');
  </script>

  <script src="https://www.gstatic.com/charts/loader.js" type="text/javascript"></script>

  <script type="text/javascript">
    Rollbar.configure({
      payload: {
        environment: "production",
        client: {
          javascript: {
            code_version: "fd54ec9aaae9fc1331eced528cce660484772fd3",
            guess_uncaught_frames: true
          }
        },
      }
    });
  </script>



<noscript>
  이 사이트의 기능을 모두 활용하기 위해서는 자바스크립트를 활성화할 필요가 있습니다.
  <a href="http://www.enable-javascript.com/ko/" target="_blank">
    브라우저에서 자바스크립트를 활성화하는 방법</a>을 참고하세요.
</noscript>
</body>
</html>
