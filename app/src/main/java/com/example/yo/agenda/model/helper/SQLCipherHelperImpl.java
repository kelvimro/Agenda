package com.example.yo.agenda.model.helper;

import com.raizlabs.android.dbflow.DatabaseHelperListener;
import com.raizlabs.android.dbflow.config.BaseDatabaseDefinition;
import com.raizlabs.dbflow.android.sqlcipher.SQLCipherOpenHelper;

/**
 * Created by yo on 03/03/2016.
 */
public class SQLCipherHelperImpl extends SQLCipherOpenHelper {


    public SQLCipherHelperImpl(BaseDatabaseDefinition databaseDefinition, DatabaseHelperListener listener) {
        super(databaseDefinition, listener);
    }

    @Override
    protected String getCipherSecret() {
        return "saçdlfashdlfkhasdl";
    }
}