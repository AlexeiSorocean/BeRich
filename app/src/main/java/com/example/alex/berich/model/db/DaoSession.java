package com.example.alex.berich.model.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.alex.berich.model.db.User;
import com.example.alex.berich.model.db.Purchase;
import com.example.alex.berich.model.db.Product;

import com.example.alex.berich.model.db.UserDao;
import com.example.alex.berich.model.db.PurchaseDao;
import com.example.alex.berich.model.db.ProductDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig purchaseDaoConfig;
    private final DaoConfig productDaoConfig;

    private final UserDao userDao;
    private final PurchaseDao purchaseDao;
    private final ProductDao productDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        purchaseDaoConfig = daoConfigMap.get(PurchaseDao.class).clone();
        purchaseDaoConfig.initIdentityScope(type);

        productDaoConfig = daoConfigMap.get(ProductDao.class).clone();
        productDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        purchaseDao = new PurchaseDao(purchaseDaoConfig, this);
        productDao = new ProductDao(productDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Purchase.class, purchaseDao);
        registerDao(Product.class, productDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        purchaseDaoConfig.getIdentityScope().clear();
        productDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public PurchaseDao getPurchaseDao() {
        return purchaseDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

}
