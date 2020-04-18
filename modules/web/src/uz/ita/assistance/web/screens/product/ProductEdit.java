package uz.ita.assistance.web.screens.product;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.Product;
import uz.ita.assistance.entity.SubProduct;

import javax.inject.Inject;

@UiController("assistance_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
//    @Inject private CollectionLoader<SubProduct> subProductsDl;
//    @Inject private InstanceContainer<Product> productDc;
//    @Inject private Table<SubProduct> subProductsTable;
//    @Inject private ScreenBuilders screenBuilders;
//
//    @Subscribe
//    protected void onBeforeShow(BeforeShowEvent event) {
//        subProductsDl.setParameter("product", getEditedEntity());
//        getScreenData().loadAll();
//    }
//
//    @Subscribe("subProductsTable.create")
//    private void onDistrictsTableCreate(Action.ActionPerformedEvent event) {
//        screenBuilders.editor(subProductsTable)
//                .newEntity()
//                .withInitializer(product -> product.setProduct(productDc.getItem()))
//                .withScreenClass(SubProductEdit.class)
//                .withLaunchMode(OpenMode.DIALOG)
//                .build()
//                .show();
//    }
}
