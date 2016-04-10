package com.example.alex.berich.data.local;

import android.database.sqlite.SQLiteDatabase;

import com.example.alex.berich.BeRichApp;
import com.example.alex.berich.data.model.DaoMaster;
import com.example.alex.berich.data.model.DaoSession;

import java.util.List;

public class DatabaseHelper {

    private static DatabaseHelper instance;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    //private ClientDao clientDao;

    public DatabaseHelper() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(BeRichApp.getAppContext(), "notes-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        //clientDao = daoSession.getClientDao();
    }

    public static DatabaseHelper getInstance() {
        if(instance == null) {
            instance = new DatabaseHelper();
        }
        return instance;
    }

//    List getClientsFromDb(String selection) {
//
//        return clientDao.queryBuilder().
//                whereOr(ClientDao.Properties.DisplayName.like("%" + selection +"%"),
//                        ClientDao.Properties.DisplayName.like("%" + selection ),
//                        ClientDao.Properties.DisplayName.like(selection+ "%" )).
//                orderAsc(ClientDao.Properties.DisplayName).list();
//    }
//
//    public void selectClients(String selection, ArrayList<VisibleClient> clients) {
//        List list = getClientsFromDb(selection);
//        for (int i = 0; i < list.size(); i++) {
//            clients.add(new VisibleClient(((Client)list.get(i))));
//        }
//    }
//
//    public void saveClient(Contact contact) {
//
//        Client client = new Client();
//        client.setDisplayName(contact.getDisplayName());
//        client.setEmail(contact.getEmail());
//        client.setCountryISO("");
//        client.setPhoneNumber(contact.getPhoneNumber());
//        client.setPhotoUri(contact.getPhotoUri());
//        client.setLastMessage("");
//        client.setLastMessageDate(null);
//        clientDao.insert(client);
//    }
//
//    public void saveClient(Client client) {
//
//        clientDao.insert(client);
//    }
//
//    public void editClient(Client client) {
//        clientDao.update(client);
//    }
//
//    public Client getClient(long id){
//        return clientDao.loadByRowId(id);
//    }

}
