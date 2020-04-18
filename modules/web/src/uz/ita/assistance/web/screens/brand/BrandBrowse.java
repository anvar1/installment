package uz.ita.assistance.web.screens.brand;

import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.Brand;

@UiController("assistance_Brand.browse")
@UiDescriptor("brand-browse.xml")
@LookupComponent("brandsTable")
@LoadDataBeforeShow
public class BrandBrowse extends StandardLookup<Brand> {
}