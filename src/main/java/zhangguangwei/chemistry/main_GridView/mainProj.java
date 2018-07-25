package zhangguangwei.chemistry.main_GridView;
import java.util.ArrayList;
import java.util.List;

import zhangguangwei.chemistry.AnnouncementPage;
import zhangguangwei.chemistry.ChemistryObject.Valence;
import zhangguangwei.chemistry.ChemistryObject.main_gridViewObj;
import zhangguangwei.chemistry.Combination;
import zhangguangwei.chemistry.GeneralName;
import zhangguangwei.chemistry.SymbolPage;

public class mainProj {
    //You can set the menu here.
    public void addToList(List<main_gridViewObj> list_main) {
        list_main.add(new main_gridViewObj(1, "元素周期表", "进行元素周期表练习", SymbolPage.class));
        list_main.add(new main_gridViewObj(2, "元素化合价", "进行元素的化合价练习", Valence.class));
        list_main.add(new main_gridViewObj(3, "化学式书写组合", "进行化学式挑战", Combination.class));
        list_main.add(new main_gridViewObj(4, "元素的俗名练习", "进行元素俗名的练习", GeneralName.class));
        list_main.add(new main_gridViewObj(5, "关于开源许可协议", "查看此程序的开源代码。并且查看源代码。", AnnouncementPage.class));
        list_main.add(new main_gridViewObj(6, "返回旧版", "看一下过去的那个丑到爆炸的临时UI.", AnnouncementPage.class));
    }
}
