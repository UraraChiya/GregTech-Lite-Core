package magicbook.gtlitecore.api.gui.impl;

import magicbook.gtlitecore.api.gui.IFluidStyle;

/**
 * Fluid Style.
 *
 * <p>
 *     Please see {@link mcjty.theoneprobe.apiimpl.styles.ItemStyle},
 *     This is just a rewrite of this class,
 *     used for {@link magicbook.gtlitecore.integration.theoneprobe.FluidStackElement}.
 * </p>
 */
public class FluidStyle implements IFluidStyle {

    private int width = 20;
    private int height = 20;

    public FluidStyle() {}

    public IFluidStyle copy() {
        return new FluidStyle().bounds(this.width, this.height);
    }

    public IFluidStyle width(int w) {
        this.width = w;
        return this;
    }

    public IFluidStyle height(int h) {
        this.height = h;
        return this;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
