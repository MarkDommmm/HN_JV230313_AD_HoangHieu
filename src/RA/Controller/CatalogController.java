package RA.Controller;

import RA.Model.Catalog;
import RA.service.CatalogService;

import java.util.List;

public class CatalogController {
    CatalogService catalogService = new CatalogService();

    public List<Catalog> getCatalogList() {
        return catalogService.getAll();
    }

    public int getSize() {
        return catalogService.getSize();
    }

    public void save(Catalog catalog) {
        catalogService.save(catalog);
    }

    public void delete(int id) {
        catalogService.delete(id);
    }

    public int getNewId() {
        return catalogService.getNewId();
    }

    public Catalog getById(int id) {
        return catalogService.findById(id);
    }

}
