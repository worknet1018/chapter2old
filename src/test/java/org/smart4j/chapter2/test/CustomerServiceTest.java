package org.smart4j.chapter2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.chapter2.helper.DatabasesHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.smart4j.chapter2.helper.DatabasesHelper.executeUpdate;

public class CustomerServiceTest {
    /*
    CustomerService 单元测试
     */
    private final CustomerService customerService;

    public CustomerServiceTest() {
        this.customerService =new CustomerService();
    }

    @Before
    public void  init() throws  Exception{
        DatabasesHelper.executeSqlFile("sql/customer_init.sql");
    }



    @Test
    public void  getCustomerListTest() throws Exception{
        List<Customer> customerList=customerService.getCustomerList();
        for (Customer customer: customerList){
            System.out.println(customer.toString());
        }
        Assert.assertEquals(2,customerList.size());
    }
    @Test
    public  void getCustomer() throws Exception{
        long id= 1;
        Customer customer=customerService.getCustomer(id);
        System.out.println(customer.toString());
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception{
        Map<String,Object> fieldMap= new HashMap<String,Object>();
        fieldMap.put("name","customer100");
        fieldMap.put("contact","John");
        fieldMap.put("telephone","123493820392");
        fieldMap.put("email","John@mail.com");
        fieldMap.put("remark","null");
        boolean result=customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void  updateCustomerTest() throws Exception{
        long id=1;
        Map<String,Object> filedMap=new HashMap<String, Object>();
        filedMap.put("contact", "Eric");
        boolean result=customerService.updateCustomer(id,filedMap);
        Assert.assertTrue(result);
    }

    @Test
    public  void deleteCustomerTest() throws  Exception{
        long id=1;
        boolean result=customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }

}
