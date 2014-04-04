package com.wicomb.TeaStealer;

import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
public class BankTask extends Task {

	public BankTask(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() == 28;
	}

	@Override
	public void execute() {
		if(ctx.bank.opened()) {
			// Change this if expanded to things like Master Farmer (Though probably won't bank for that)
			ctx.bank.depositInventory();
		}
		Item bankStall= ctx.bank.select().shuffle().poll();
		if(bankStall.inViewport()) {
			bankStall.interact("Bank");
		} else {
			ctx.movement.step(Constants.bankTile.derive(Random.nextInt(0, 4),0));
		}
	}

}
