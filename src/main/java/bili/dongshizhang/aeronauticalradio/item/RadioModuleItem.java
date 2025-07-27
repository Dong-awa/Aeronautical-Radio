
package bili.dongshizhang.aeronauticalradio.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RadioModuleItem extends Item {
	public RadioModuleItem() {
		super(new Item.Properties().stacksTo(32).rarity(Rarity.COMMON));
	}
}
