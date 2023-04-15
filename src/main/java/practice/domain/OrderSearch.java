package practice.domain;

public class OrderSearch {

    private String memberName;  //회원이름
    private OrderStatus orderStatus;    //주문상태[ORDER, CANCEL]

    //Getter, Setter

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
