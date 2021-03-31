package com.arsene.storageservice.utililties;

import com.arsene.storageservice.entity.artifacts.MetaModelType;
import com.arsene.storageservice.entity.artifacts.ModelType;
import com.arsene.storageservice.entity.dsl.DslType;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

@Component
public class UtilImpl implements ServiceUtil{
    public boolean isTypeValid(String filename, String type){
        // Split the filename to extension and name
        String[] str = filename.split("[.]", 0);
        boolean exist = false;

        switch (type){
            case "DSL":
                exist = EnumUtils.isValidEnum(DslType.class, str[1].toUpperCase());
                break;
            case "MODEL":
                exist = EnumUtils.isValidEnum(ModelType.class, str[1].toUpperCase());
                break;
            case "METAMODEL":
                exist = EnumUtils.isValidEnum(MetaModelType.class, str[1].toUpperCase());
                break;
        }

        return exist;
    }
}
