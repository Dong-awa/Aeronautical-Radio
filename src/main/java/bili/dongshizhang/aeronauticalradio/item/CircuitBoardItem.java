
package bili.dongshizhang.aeronauticalradio.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CircuitBoardItem extends Item {
	public CircuitBoardItem() {
		super(new Item.Properties().stacksTo(32).rarity(Rarity.COMMON));
	}
}
