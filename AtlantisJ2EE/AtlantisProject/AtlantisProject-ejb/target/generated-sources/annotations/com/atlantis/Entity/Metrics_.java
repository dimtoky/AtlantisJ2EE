package com.atlantis.Entity;

import com.atlantis.Entity.Devices;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-29T00:25:33")
@StaticMetamodel(Metrics.class)
public class Metrics_ { 

    public static volatile SingularAttribute<Metrics, Date> createdAt;
    public static volatile SingularAttribute<Metrics, Integer> idmetrics;
    public static volatile SingularAttribute<Metrics, String> metricValue;
    public static volatile SingularAttribute<Metrics, Devices> deviceID;

}