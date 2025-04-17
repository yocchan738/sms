<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>複数の柱</title>
  <style>
  body {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin: 0;
  background-image: url("../parts/a.png");
  background-size: 100px;
}
 
.container {
  display: flex;
  gap: 180px;
}
 
.item1 {
  width: 200px;
  height: 100px;
}

.item2{
  width: 200px;
  height: 75px;
 }

.scene {
  perspective: 1000px;
  width: 100%;
  height: 100%;
}

.top{
  position: absolute;
  left: 46%;
  top: 0%;
  background-color: black;
  color: #fff;
  font-size: 50px;
  
}

.p1 {
  position: absolute;
  left: 16.5%;
  top: 22%;
  background-color: black;
  color: #fff;
  
}

.p2 {
  position: absolute;
  left: 46%;
  top: 22%;
  background-color: black;
  color: #fff;
}

.p3 {
  position: absolute;
  left: 76%;
  top: 22%;
  background-color: black;
  color: #fff;
}
 
.quadrangular-prism,
.hexagonal-prism {
  position: relative;
  width: 100%;
  height: 100%;
  transform-style: preserve-3d;
  animation: rotateX 5s linear infinite;

}
 

 
.face {
  position: absolute;
  width: 100%;
  height: 100%;
  background: rgba(255, 255, 255, 0.8);
  border: 1px solid #ccc;
  text-align: center;
  line-height: 100px;
  font-weight: bold;
  color: #000;
  box-sizing: border-box;
}

.facea {
  position: absolute;
  width: 100%;
  height: 100%;
  background: rgba(255, 255, 255, 0.8);
  border: 1px solid #ccc;
  text-align: center;
  line-height: 100px;
  font-weight: bold;
  color: #000;
  box-sizing: border-box;
}
 
.face a {
  display: block;
  width: 100%;
  height: 100%;
  color: inherit;
  text-decoration: none;
  line-height: 100px;
  font-size: 24px;
  transition: background 0.3s, color 0.3s;
}

.facea a {
  display: block;
  width: 100%;
  height: 100%;
  color: inherit;
  text-decoration: none;
  line-height: 73px;
  font-size: 24px;
  transition: background 0.3s, color 0.3s;
}
 
.face a:hover ,.facea a:hover {
  background: rgba(255, 255, 255, 1);
  color: #333;
}
 
/* 四角柱の面 */
.quad .face1 { transform: translateZ(50px); background: red; }
.quad .face2 { transform: rotateX(90deg) translateZ(50px); background: orange; }
.quad .face3 { transform: rotateX(180deg) translateZ(50px); background: yellow; }
.quad .face4 { transform: rotateX(-90deg) translateZ(50px); background: green; }
 
/* 六角柱の面 */
.hexa .face1 { transform: rotateX(0deg) translateZ(65px); background: red; }
.hexa .face2 { transform: rotateX(60deg) translateZ(65px); background: orange; }
.hexa .face3 { transform: rotateX(120deg) translateZ(65px); background: yellow; }
.hexa .face4 { transform: rotateX(180deg) translateZ(65px); background: green; }
.hexa .face5 { transform: rotateX(240deg) translateZ(65px); background: blue; }
.hexa .face6 { transform: rotateX(300deg) translateZ(65px); background: purple; }
 
@keyframes rotateX {
  0% { transform: rotateX(0deg); }
  100% { transform: rotateX(360deg); }
}
  
  </style>
</head>
<body>
  <div class="container">
    <h1 class="top"><span style="color:blue;">T</span><span style="color:yellow;">O</span><span style="color:red;">P</span></h1>

    <p class="p1">学生管理機能</p>

    <!-- 四角柱1 -->
    <div class="item1">
      <div class="scene">
        <div class="quadrangular-prism quad">
          <div class="face face1"><a href="/sms/studentmanagement/list" target="_blank">学生管理一覧</a></div>
          <div class="face face2"><a href="/sms/studentmanagement/delete/select" target="_blank">学生削除</a></div>
          <div class="face face3"><a href="/sms/studentmanagement/update/select" target="_blank">学生変更</a></div>
          <div class="face face4"><a href="/sms/studentmanagement/insert" target="_blank">学生登録</a></div>
        </div>
      </div>
    </div>
 
    <p class="p2">科目管理機能</p>
    <!-- 四角柱2 -->
    <div class="item1">
      <div class="scene">
        <div class="quadrangular-prism quad">
          <div class="face face1"><a href="/sms/subjectmanagement/list" target="_blank">科目登録</a></div>
          <div class="face face2"><a href="/sms/subjectmanagement/delete/select" target="_blank">科目削除</a></div>
          <div class="face face3"><a href="/sms/subjectmanagement/update/select" target="_blank">科目変更</a></div>
          <div class="face face4"><a href="/sms/subjectmanagement/insert" target="_blank">科目登録</a></div>
        </div>
      </div>
    </div>
 
    <p class="p3">成績管理機能</p>
    <!-- 六角柱 -->
    <div class="item2">
      <div class="scene">
        <div class="hexagonal-prism hexa">
          <div class="facea face1"><a href="/sms/scoremanagement/list" target="_blank">成績一覧</a></div>
          <div class="facea face2"><a href="/sms/scoremanagement/delete/select" target="_blank">成績削除</a></div>
          <div class="facea face3"><a href="/sms/scoremanagement/update/select" target="_blank">成績変更</a></div>
          <div class="facea face4"><a href="/sms/scoremanagement/insert" target="_blank">成績登録</a></div>
          <div class="facea face5"><a href="/sms/subjectscoremanagement/search" target="_blank">科目別成績一覧</a></div>
          <div class="facea face6"><a href="/sms/studentscoremanagement/search" target="_blank">学生別成績一覧</a></div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
