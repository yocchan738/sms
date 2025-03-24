<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一旦何でもいい</title>
<style type="text/css">
 /* サイドメニューのスタイル */
        .side_menu {
            width: 15%;  /* 画面の15%の幅を確保 */
            height: 100vh;  /* 画面全体の高さ */
            position: fixed; /* 画面左端に固定配置 */
            top: 0;
            left: 0;
            padding: 20px;
            box-sizing: border-box; /* paddingを含めたサイズ調整 */
        }

        /* サイドメニューの右端に縦線を追加 */
        .side_menu::after {
            content: "";
            position: absolute;
            top: 0;
            right: 0;
            width: 1px; /* 縦線の太さ */
            height: 100%;
            background-color: black; /* 縦線の色 */
        }

        /* メインコンテンツのスタイル */
        .content {
            margin-left: 15%; /* サイドメニューの幅と揃える */
        }
</style>
</head>
<body>