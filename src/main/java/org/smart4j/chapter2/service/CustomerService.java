package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.helper.DatabasesHelper;
import org.smart4j.chapter2.model.Customer;
import java.util.*;
public class CustomerService {

    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerService.class);



    public List<Customer> getCustomerList(){
        String sql="SELECT * FROM customer";
        return DatabasesHelper.queryEntityList(Customer.class,sql);
    }
    public  Customer getCustomer(long id){
        String sql="SELECT * FROM customer WHERE id =?";
        return DatabasesHelper.queryEntity(Customer.class,sql,id);
    }

    /**
     * 创建用户
     * @param fieldMap
     * @return
     */
    public  boolean createCustomer(Map<String,Object> fieldMap){
        return DatabasesHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新用户
     * @param id
     * @param fieldMap
     * @return
     */
    public boolean updateCustomer(long id,Map<String,Object> fieldMap){
        return DatabasesHelper.updateEntity(Customer.class,id,fieldMap);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public boolean deleteCustomer(long id){
        return DatabasesHelper.deleteEntity(Customer.class,id);
    }

}
