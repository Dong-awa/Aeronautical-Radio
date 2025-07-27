
package bili.dongshizhang.aeronauticalradio.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ElectronicComponentItem extends Item {
	public ElectronicComponentItem() {
		super(new Item.Properties().stacksTo(32).rarity(Rarity.COMMON));
	}
}
