package RA.service;

import RA.Model.Catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogService implements IService<Catalog, Integer> {

    private List<Catalog> catalogs;

    public CatalogService() {
        catalogs = new ArrayList<>();
        catalogs.add(new Catalog(1,"Shirt"));
    }

    public int getSize() {
        return catalogs.size();
    }

    @Override
    public List<Catalog> getAll() {
        return catalogs;
    }

    @Override
    public void save(Catalog catalog) {
        catalogs.add(catalog);
    }

    @Override
    public Catalog findById(Integer catalogId) {
        for (Catalog catalog : catalogs) {
            if (catalog.getCatalogId() == catalogId) {
                System.out.println(catalog);
                return catalog;
            }
        }
        System.out.println("Không tim thấy danh mục");
        return null;
    }

    @Override
    public void delete(Integer catalogId) {
        for (Catalog catalog : catalogs) {
            if (catalog.getCatalogId() == catalogId) {
                catalogs.remove(catalog);
                System.out.println("Danh mục đã được xóa!!!");
                return;
            }
        }
        System.out.println("Không tim thấy danh mục");
    }

    public int getNewId() {
        int max = 0;
        for (Catalog catalog : catalogs) {
            if (catalog != null && catalog.getCatalogId() > max) {
                max = catalog.getCatalogId();
            }
        }
        return max + 1;
    }

}
