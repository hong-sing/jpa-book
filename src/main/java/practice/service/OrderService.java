package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.domain.*;
import practice.domain.item.Item;
import practice.exception.NotEnoughStockException;
import practice.exception.repository.MemberRepository;
import practice.exception.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemService itemService;

    /**
     * 주문
     */
    public Long order(Long memberId, Long itemId, int count) throws NotEnoughStockException {
        //엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemService.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery(member.getAddress());
        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        //주문생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문저장
        orderRepository.save(order);
        return order.getId();
    }

    /**
     * 주문취소
     */
    public void cancelOrder(Long orderId) {
        //주문엔티티 조회
        Order order = orderRepository.findOne(orderId);
        //주문취소
        order.cancel();
    }

    /**
     * 주문 검색
     */
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch);
    }
}
