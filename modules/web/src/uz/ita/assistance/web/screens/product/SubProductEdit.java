package uz.ita.assistance.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.SubProduct;

@UiController("assistance_SubProduct.edit")
@UiDescriptor("sub-product-edit.xml")
@EditedEntityContainer("subProductDc")
@LoadDataBeforeShow
public class SubProductEdit extends StandardEditor<SubProduct> {
}
