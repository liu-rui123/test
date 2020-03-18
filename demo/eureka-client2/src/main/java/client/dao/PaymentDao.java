package client.dao;

import com.liu.springCloud.springCloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentDao {
    public Payment getPaymentById(String  serial);
    public Integer create(Payment p);
    public List<Payment> all();
    public  int delete(Long id);
    public  int update(Payment payment);
}
