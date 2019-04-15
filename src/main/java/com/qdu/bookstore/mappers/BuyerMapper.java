package com.qdu.bookstore.mappers;

import com.qdu.bookstore.buyer.pojo.Buyer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author ShaneLau
 * Created by Shane Lau on 2019/4/1.
 */
@Mapper
public interface BuyerMapper {
    public void addBuyer(Buyer buyer);

    Buyer selectBuyerByUsername(String buyer_username);

    Buyer selectBuyerByUsernameAndPassword(String buyer_username,String buyer_password);
    int updateBuyer(Buyer buyer);
}
