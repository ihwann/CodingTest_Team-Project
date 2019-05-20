
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div class="main-section">
  <div class="guide-section" id="tour2">
    <div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.<br>
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA</p>

<p>조이스틱을 각 방향으로 움직이면 아래와 같습니다.</p>
<div class="highlight">
<pre class="codehilite">
<span style="line-height: 10%"><br></span>
<code>▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동
</code>
</pre>
</div>



<p>예를 들어 아래의 방법으로 <q>JAZ</q>를 만들 수 있습니다.</p>
<div class="highlight"><pre class="codehilite">
<span style="line-height: 10%"><br></span>
<code>- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
</code>
<span style="line-height: 10%"><br></span>
</pre></div>
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
		</div>
	</div>
	
</div>
  
  
  
  
  
  <div class="run-section">
    <div id="tour3" class="code-section" onkeyup="Hera.tryoutChallenges.resizeEditor(this);">
      <div class="editor">
 


<h6 class="guide-section-title" style="padding-left: 20px">solution.java</h6>

<hr>

         	 <textarea  id="code" name="code" style="height: 400px;width: 1000px;background-color: #263747;color:white;border: 0px">

class Solution {
    public int solution(String name) {
        int answer = 0;
        return answer;
    }
}
</textarea>
      </div>
    </div>

    <div class="output-section" id="tour6">
      <div class="tab-header">
      <hr>
          실행 결과
      
      <div style="display: inline;align-content: right; margin-left: 90%">
	      <input type="button" value="submit" style="color:white;background-color:#263747;border-radius: 12px; "> 
      </div>
      	
         
      
	
      </div>
      
      <hr>   
      <div class="console tab-content">
          실행 결과가 여기에 표시됩니다.
      </div>
    </div>
  </div>
</div>

