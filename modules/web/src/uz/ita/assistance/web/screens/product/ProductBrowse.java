package uz.ita.assistance.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.Product;

@UiController("assistance_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {
}