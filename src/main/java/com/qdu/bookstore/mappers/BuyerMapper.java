package com.qdu.bookstore.mappers;

import com.qdu.bookstore.buyer.pojo.Buyer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;

/**
 * @Author ShaneLau
 * Created by Shane Lau on 2019/4/1.
 */
@Mapper
public interface BuyerMapper {
    public void addBuyer(Buyer buyer);

    Buyer selectBuyerByUsername(@Param(value = "buyer_Username") String buyer_username);

    Buyer selectBuyerByUsernameAndPassword(@Param(value = "buyer_Username") String buyer_username,
                                           @Param(value = "buyer_Password") String buyer_password);
    int updateBuyer(Buyer buyer);
}
