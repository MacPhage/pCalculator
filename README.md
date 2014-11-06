
<style>
.announcement {
  font-size: 96px;
}

.blink_me {
    -webkit-animation-name: blinker;
    -webkit-animation-duration: 1s;
    -webkit-animation-timing-function: linear;
    -webkit-animation-iteration-count: infinite;
    -webkit-transition: color 0.5s;

    -moz-animation-name: blinker;
    -moz-animation-duration: 1s;
    -moz-animation-timing-function: linear;
    -moz-animation-iteration-count: infinite;
    -moz-transition: color 0.5s;
        
    -ms-transition: color 0.5s;
    -o-transition: color 0.5s;
    

    animation-name: blinker;
    animation-duration: 1s;
    animation-timing-function: linear;
    animation-iteration-count: infinite;
    transition: color 0.5s;
}

@-moz-keyframes blinker {  
    0% { color: #ef7c7c; }
    25% { opacity: #f24444; }
    50% { opacity: #ef2a2a; }
    75% { opacity: #f24444; }
    100% { opacity: #ef7c7c; }
}

@-webkit-keyframes blinker {  
    0% { color: #ef7c7c; }
    25% { opacity: #f24444; }
    50% { opacity: #ef2a2a; }
    75% { opacity: #f24444; }
    100% { opacity: #ef7c7c; }
}

@keyframes blinker {  
    0% { color: #ef7c7c; }
    25% { opacity: #f24444; }
    50% { opacity: #ef2a2a; }
    75% { opacity: #f24444; }
    100% { opacity: #ef7c7c; }
}
</style>

<p class="announcement blink_me">pCalculator as a project is going currently inactive, however, a JavaScript port/revamp is being developed over at <a href="https://github.com/MacPhage/alfeo">MacPhage/alfeo</a></p>

<img src="http://macphage.github.io/img/pcalculatorlogo.png" width="600" height="200"></img>

<h1>Description</h1>
pCalculator is a light-weight Java application for convenient calculation.<br>It is designed to do as fully functional and do-all-the-work-for-you as possible.<br><i>Happy mathing!</i>

<h1>Commands</h1>
<blockquote>
<h3>Guide</h3>
<ul>
<li>List = multiple inputs seperated by spaces.</li>
<li>Commands ARE case-sensitive! Typing "add" is different from "ADD".</li>
<li>Things with [] are required.</li>
<li>Things with () are optional.</li>
</ul>
<h3>Command list</h3>
<ul>

<li>Help</li>
<blockquote>
<ul>
<li>Use "help"</li>
</ul>
</blockquote>

<li>Info</li>
<blockquote>
<ul>
<li>Use "info"</li>
</ul>
</blockquote>

<li>Add</li>
<blockquote>
<ul>
<li>Use "add [list]"</li>
</ul>
</blockquote>

<li>Subtract</li>
<blockquote>
<ul>
<li>Use "subtract [list]"</li>
<li>Subtracts all other numbers from the first number</li>
</ul>
</blockquote>


<li>Multiply</li>
<blockquote>
<ul>
<li>Use "multiply [list]"</li>
</ul>
</blockquote>

<li>Divide</li>
<blockquote>
<ul>
<li>Use "divide [list]"</li>
<li>Divides all other numbers from the first number</li>
</ul>
</blockquote>

<li>Power</li>
<blockquote>
<ul>
<li>Use "power [list]"</li>
<li>Powers the first number to the second number, then the third, etc</li>
</ul>
</blockquote>

<li>Squareroot</li>
<blockquote>
<ul>
<li>Use "squareroot [list]"</li>
</ul>
</blockquote>

<li>Factorial</li>
<blockquote>
<ul>
<li>Use "factorial [list]"</li>
</ul>
</blockquote>

<li>Quadratic Formula</li>
<blockquote>
<ul>
<li>Use "quadraticFormula [a] [b] [c]"</li>
</ul>
</blockquote>

<li>Greatest Common Divisor</li>
<blockquote>
<ul>
<li>Use "gcd [list]"</li>
</ul>
</blockquote>

<li>Least Common Multiple</li>
<blockquote>
<ul>
<li>Use "lcm [list]"</li>
</ul>
</blockquote>

<li>Simplify</li>
<blockquote>
<ul>
<li>Use "simplify [type] [list]"</li>
<li>Valid types: "fraction, (none)"</li>
<li>Example: "simplify fraction 5 10 5 15</li>
</ul>
</blockquote>

</ul>
</blockquote>
