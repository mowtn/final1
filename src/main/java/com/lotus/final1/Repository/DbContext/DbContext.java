package com.lotus.final1.Repository.DbContext;

import com.lotus.final1.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbContext {
    @Autowired
    public ProductDetailPropertydetailRP productDetailPropertydetailRP;
    @Autowired
    public ProductdetailRP productdetailRP;
    @Autowired
    public ProductRP productRP;
    @Autowired
    public PropertydetailRP propertydetailRP;
    @Autowired
    public PropertyRp propertyRp;
}
