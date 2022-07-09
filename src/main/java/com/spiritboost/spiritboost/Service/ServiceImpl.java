package com.spiritboost.spiritboost.Service;

import com.spiritboost.spiritboost.Dao.CustomerDao;
import com.spiritboost.spiritboost.Entity.Customer;
import com.spiritboost.spiritboost.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    private final CustomerDao customerDao;

    @Autowired
    public ServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    //增 post
    @Override
    public void saveUser(Customer customer) {
        customerDao.save(customer);
    }

    //查 get
    @Override
    public List<Customer> getUserList() {
        return customerDao.getList();
    }

    @Override
    public Optional<Customer> getUserById(Long id) {
        return customerDao.findCustomerById(id);
    }

    //更新
    @Override
    @Transactional
    public void updateCustomer(Long id, Customer customer1) {
        //判断是否存在这个ID
        Optional<Customer> customer = customerDao.findCustomerById(id);
        Customer customerObj = customer.get();
        if(customer.isEmpty()) {
            new UserNotFoundException("customer with id: " + id + "doesn't exist");
        }
        else {
            //判断新输入的内容是否和之前的重叠
            if(customer1.getName() != null && !Objects.equals(customer.get().getName(),customer1.getName())) {
                customerObj.setName(customer1.getName()); //optional.get() -> return value
            }

            if(customer1.getPassword() != null && !Objects.equals(customer.get().getPassword(),customer1.getPassword())) {
                customer.get().setPassword(customer1.getPassword());
            }
            System.out.println(customer);
        }
    }



    @Override
    @Transactional
    public void deteleCustomer(Long id) {
        //判断是否存在这个customer
        //如果找不到学生处理的方法
        Optional<Customer> customer = customerDao.findCustomerById(id);
        Boolean notExist = customer.isEmpty(); //如果返回的Optional容器里面是null，则为true
        System.out.println(notExist);
        if (notExist) {
            new UserNotFoundException("Customer with id: " + id + "doesn't exist");
        }
        customerDao.delete(customer.get());
    }
}
