<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>
    Header
  </title>
  <style>
    

body {
  margin: 0;
  padding: 0;
  color: #1a1a1a;
  background: #f6f5f4;
}

header {
  width: 100%;
  height: 10%;
  background: #ffffff;
  box-sizing: border-box;
  display: flex;
  /* flexboxを作る */
  align-items: center;
  /* 上下中央に揃える */
  justify-content: space-between;
  /* 両端に配置 */
  position: fixed;
  top: 0;
  z-index: 999;
  border-bottom: 2px solid #ddd; 
  padding: 10px;
}

ul.header_nav {
  list-style: none;
  display: flex;
}

ul li a {
  padding: 10px 15px;
  color: #1a1a1a;
  text-decoration: none;
  font-weight: bold;
}

.sidebar {
  position: fixed;  
  margin-top: 55px;   
  top: 0; 
  left: 0;
  width: 15%;
  height: 83vh;
  background-color: #333;
  color: white;
  padding: 20px;
  box-sizing: border-box;
  overflow-y: auto;
}

.sidebar a.item {
  color: white;
  text-decoration: none;
  padding: 10px;
  display: block;
  font-size: 13px;
}

.sidebar a.item:hover {
  background-color: #575757; 
}

.sidebar_item {
  margin-top: 20px;
  font-weight: bold;
}

.menu a.item {
  padding-left: 20px;
}

.icon {
  margin-right: 8px;
}

  .header_nav a {
    text-decoration: none;
    color: black;
    padding: 10px;
    transition: color 0.3s ease, background-color 0.3s ease;
  }

  .header_nav a:hover {
    color: white; 
    background-color: #65696c; 
    border-radius: 5px; 
  }

  .top_btn a, .logout_btn a {
    padding: 10px 20px;
    display: block;
  }

  a.title {
    margin-left: 20px;
    font-weight: bold;                 /* 太字に設定 */
    color: #333;                       /* リンクの文字色をダークグレーに設定 */
    text-decoration: none;             /* 下線をなくす */
    transition: color 0.3s, transform 0.3s; /* 色と変形にスムーズな遷移を追加 */
  }
  
  a.title:hover {
    color: #737275;                   /* ホバー時の文字色をオレンジに設定 */
    text-decoration: underline;        /* ホバー時に下線を追加 */
    transform: scale(1.1);             /* ホバー時に少し大きくする */
  }

  .wrapper{
    min-height: 100vh;
    position: relative;
  }
  
  footer{
    background-color: #ffffff;
    border-top:2px solid #ddd ;
    width: 100%;
    height: 10vh;
    position: absolute;
    left: 0;
    bottom: 0;
    text-align: center;
  }

  </style>
</head>

<body>

  <header>
    <h1><a href="" class="title">得点管理システム</a></h1>
      <nav>
        <ul class="header_nav">
            <li class="top_btn"><a href="">Top</a></li>
            <li class="logout_btn"><a href="">Logout</a></li>
        </ul>
    </nav>
</header>