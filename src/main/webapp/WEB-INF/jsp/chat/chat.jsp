<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
        <title>Чат</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
        <script src="../resources/js/chat/index.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="../resources/css/chat/chat.css">
    </head>
    <body>
        <noscript>
            <h2>This browser not supported Javascript</h2>
        </noscript>
        <div id="chat-page" class="hidden">
            <div class="chat-container">
                <div class="chat-header">
                    <h2>Chat</h2>
                </div>
                <div class="connecting">
                    Connecting...
                </div>
                <ul id="messageArea"></ul>
                <form id="messageForm" name="messageForm">
                    <div class="form-group">
                        <div class="input-group clearfix">
                            <input type="text" id="message" placeholder="text message" autocomplete="off" class="form-control"/>
                            <button type="submit" class="primary">Send</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script>
            $( document ).ready(function() {
                connect("${username}")
            });
        </script>
    </body>
</html>