
public class NetworkClient  {
    private  String url;

    public NetworkClient() {
        System.out.println("construct url = " + url);
        connect();
        call("초기화 연결 메세지");
        System.out.println("---------생성자---------");
    }
    public void setUrl(String url) {
        this.url = url;
    }
    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }
    public void call(String message) {
        System.out.println("call : "+ url + " message = " +message) ;
    }
    public void disconnect() {
        System.out.println("close : " + url);
    }

    @Override
    public String toString() {
        return "NetworkClient{" +
                "url='" + url + '\'' +
                '}';
    }
    public void init() throws Exception {
        //객체 생성 -> 의존성 주입 -> 초기화 콜백 메서드 호출
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        System.out.println("--------초기화 콜백 메서드----------");

    }
    //소멸 전 콜백 메서드 호출 -> 스프링 컨테이너 다운
    public void close() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
        System.out.println("--------소멸전 콜백 메서드----------");
    }
}
