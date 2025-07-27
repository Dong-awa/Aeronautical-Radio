
package bili.dongshizhang.aeronauticalradio.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PCBItem extends Item {
	public PCBItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
