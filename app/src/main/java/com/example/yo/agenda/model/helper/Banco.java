package com.example.yo.agenda.model.helper;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by yo on 04/02/2016.
 */

@Database(name=Banco.NAME,version = Banco.VERSION)
public class Banco{
    public static final String NAME = "dbAgenda";
    public static final int VERSION = 1;
}
