package magicbook.gtlitecore.api.gui.impl;

import magicbook.gtlitecore.api.gui.IFluidStyle;
import magicbook.gtlitecore.integration.theoneprobe.FluidStackElement;
import mcjty.theoneprobe.apiimpl.styles.ItemStyle;

/**
 * Fluid Style Builder
 *
 * <p>
 *     This class is impl class of the interface {@link IFluidStyle},
 *     just like {@link ItemStyle}, this class create a new style for {@link FluidStackElement}.
 * </p>
 *
 * @since 1.4.28
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
