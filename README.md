[![Logo](./logo.png)](https://bitmart.com)

BitMart-Java-SDK-API
=========================
<p align="left">
    <a href='#'><img src='https://travis-ci.org/meolu/walle-web.svg?branch=master' alt="Build Status"></a>  
</p>

Java client for the [BitMart Cloud API](http://developer-pro.bitmart.com).



Feature
=========================
- Provides exchange quick trading API
- Easier withdrawal
- Efficiency, higher speeds, and lower latencies
- Priority in development and maintenance
- Dedicated and responsive technical support
- Provide webSocket apis calls


Installation
=========================

* 1.JDK 1.8 support

* 2.Clone
```git
git clone git@github.com:bitmartexchange/bitmart-java-sdk-api.git
```



Usage
=========================
* An example of a spot trade API
* Replace it with your own API KEY
* Run

#### API Example
```java
public class TestSpot {

    private static String API_KEY = "YOUR ACCESS KEY";
    private static String API_SECRET = "YOUR SECRET KEY";
    private static String API_MEMO = "YOUR MEMO";
    private static Call call;

    TestSpot(){
        CloudContext cloudContext = new CloudContext(new CloudKey(API_KEY, API_SECRET, API_MEMO));
        call = new Call(cloudContext);
        
          System.out.println(
                        call.callCloud(new SystemServiceRequest())
                );
    }

}
```

#### WebSocket Public Channel Example
```java
public class TestWebSocket {

    TestWebSocket() throws Exception{

        // 1.Connection
        WebSocketClient webSocketClient = new WebSocketClient(
                "wss://ws-manager-compress.bitmart.com/api?protocol=1.1", new ReceiveMessage());
        
        // 2. send subscribe message
        webSocketClient.subscribe(ImmutableList.of(

                // public channel
                createChannel(WS_PUBLIC_SPOT_TICKER, "BTC_USDT"),
                createChannel(WS_PUBLIC_SPOT_DEPTH5, "BTC_USDT")

        ));
        
    }

    public class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            System.out.println(text);
        }

    }
}

```

#### WebSocket Private Channel Example
```java
public class TestWebSocket {

    private static String API_KEY = "YOUR ACCESS KEY";
    private static String API_SECRET = "YOUR SECRET KEY";
    private static String API_MEMO = "YOUR MEMO";

    TestWebSocket() throws Exception{

        // 1.Connection
        WebSocketClient webSocketClient = new WebSocketClient(
                "wss://ws-manager-compress.bitmart.com/user?protocol=1.1", new ReceiveMessage());
        
        // 2. login
        webSocketClient.login();

        Thread.sleep(2000L); // wait login

        // 3. send subscribe message
        webSocketClient.subscribe(ImmutableList.of(

                // private channel
                createChannel(WS_USER_SPOT_ORDER, "BTC_USDT")

        ));
        
    }

    public class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            System.out.println(text);
        }

    }
}

```

Release Notes
=========================

###### 2020-07-16 
- Interface Spot API `Cancel Order` update to v2 version that is `POST https://api-cloud.bitmart.com/spot/v2/cancel_order`
- UserAgent set "BitMart-Java-SDK/1.0.1"
                                                    
 
###### 2020-09-21
- Interface Spot API `/spot/v1/symbols/book` add `size` parameter, which represents the number of depths


###### 2021-01-19
- New endpoints for Spot WebSocket
    - Public - ticket channels
    - Public - K channel
    - Public - trading channels
    - Public - depth channels
    - Login
    - User - Trading Channel


###### 2021-11-06
- Update endpoints for Spot WebSocket
    - Public-Depth Channel:
        - spot/depth50     50 Level Depth Channel
        - spot/depth100    100 Level Depth Channel
    - User-Trade Channel:
        - Eligible pushes add new orders successfully


###### 2021-11-24
- New endpoints for Spot
    - <code>/spot/v2/orders</code>Get User Order History V2
    - <code>/spot/v1/batch_orders</code>Batch Order
- Update endpoints for Spot
    - <code>/spot/v1/symbols/kline</code>Add new field 'quote_volume'
    - <code>/spot/v1/symbols/trades</code>Add optional parameter N to return the number of items, the default is up to 50 items
    - <code>/spot/v1/order_detail</code>Add new field 'unfilled_volume'
    - <code>/spot/v1/submit_order</code>The request parameter type added limit_maker and ioc order types
- New endpoints for Account
    - <code>/account/v2/deposit-withdraw/history</code>Get Deposit And Withdraw  History V2
- Update endpoints for Account
    - <code>/account/v1/wallet</code>Remove the account_type,Only respond to currency accounts; you can bring currency parameters (optional)


###### 2022-01-18
- websocket public channel address<code>wss://ws-manager-compress.bitmart.com?protocol=1.1</code>will be taken down on 2022-02-28 UTC time,The new address is<code>wss://ws-manager-compress.bitmart.com/api?protocol=1.1</code>


###### 2022-01-20
- Update endpoints for Spot
    - <code>/spot/v1/symbols/details</code>Add a new respond parameter trade_status, to show the trading status of a trading pair symbol.

License
=========================
