package magicbook.gtlitecore.mixin.architecturecraft;

/*
 * Copyright (c) 2023 Nomifactory-CEu
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 2.1 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 */

import com.elytradev.architecture.client.render.shape.RenderRoof;
import com.elytradev.architecture.client.render.shape.RenderShape;
import com.elytradev.architecture.client.render.target.RenderTargetBase;
import com.elytradev.architecture.client.render.texture.ITexture;
import com.elytradev.architecture.common.helpers.Trans3;
import com.elytradev.architecture.common.tile.TileShape;
import magicbook.gtlitecore.integration.architecturecraft.GTLiteShapes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author IntegerLimit
 */
@Mixin(value = RenderRoof.class, remap = false)
public abstract class MixinRenderRoof extends RenderShape {

    @Unique
    private Map<Integer, Runnable> ID_TO_RENDER_MAP = null;

    @Shadow
    protected abstract void bottomQuad();

    @Shadow
    protected abstract void backQuad();

    @Shadow
    protected abstract void beginNegZSlope();

    @Shadow
    protected abstract void beginQuad();

    @Shadow
    protected abstract void vertex(double x, double y, double z, double u, double v);

    @Shadow
    protected abstract void endFace();

    @Shadow
    protected abstract void beginPosXFace();

    @Shadow
    protected abstract void beginTriangle();

    @Shadow
    protected abstract void beginNegZFace();

    @Shadow
    protected abstract void beginPosZFace();

    @Shadow
    protected abstract void beginNegXFace();

    /**
     * Default Ignored Constructor
     */
    public MixinRenderRoof(TileShape te, ITexture[] textures, Trans3 t, RenderTargetBase target) {
        super(te, textures, t, target);
    }

    @Unique
    private Map<Integer, Runnable> getRenderMap() {
        if (ID_TO_RENDER_MAP != null) return ID_TO_RENDER_MAP;

        ID_TO_RENDER_MAP = new HashMap<>();
        ID_TO_RENDER_MAP.put(GTLiteShapes.SLOPE_TILE_A1.id, this::renderSlopeA1);
        ID_TO_RENDER_MAP.put(GTLiteShapes.SLOPE_TILE_A2.id, this::renderSlopeA2);
        ID_TO_RENDER_MAP.put(GTLiteShapes.SLOPE_TILE_B1.id, this::renderSlopeB1);
        ID_TO_RENDER_MAP.put(GTLiteShapes.SLOPE_TILE_B2.id, this::renderSlopeB2);
        ID_TO_RENDER_MAP.put(GTLiteShapes.SLOPE_TILE_B3.id, this::renderSlopeB3);
        ID_TO_RENDER_MAP.put(GTLiteShapes.SLOPE_TILE_C1.id, this::renderSlopeC1);
        ID_TO_RENDER_MAP.put(GTLiteShapes.SLOPE_TILE_C2.id, this::renderSlopeC2);
        ID_TO_RENDER_MAP.put(GTLiteShapes.SLOPE_TILE_C3.id, this::renderSlopeC3);
        ID_TO_RENDER_MAP.put(GTLiteShapes.SLOPE_TILE_C4.id, this::renderSlopeC4);
        return ID_TO_RENDER_MAP;
    }

    @Inject(method = "render",
            at = @At("HEAD"),
            cancellable = true)
    public void renderCustomSlopes(CallbackInfo ci) {
        var map = getRenderMap();
        var id = te.getShape().id;
        if (!map.containsKey(id)) return;
        map.get(id).run();
        ci.cancel();
    }

    // -------------------------------------------------------------------------------------
    @Unique
    protected void renderSlopeA1() {
        renderVariableSlope(1.0, 0.5);

        renderVariableFaceLeft(0, 0.5);
        renderVariableTriangleLeft(0.5, 0.5);

        renderVariableFaceRight(0, 0.5);
        renderVariableTriangleRight(0.5, 0.5);

        renderVariableFrontFace(0.5);

        bottomQuad();
        backQuad();
    }

    @Unique
    protected void renderSlopeA2() {
        renderVariableSlope(0.5, 0);

        renderVariableTriangleLeft(0, 0.5);

        renderVariableTriangleRight(0, 0.5);

        bottomQuad();
        renderVariableBackFace(0.5);
    }

    @Unique
    protected void renderSlopeB1() {
        renderVariableSlope(1.0, 0.66666);

        renderVariableFaceLeft(0, 0.66666);
        renderVariableTriangleLeft(0.66666, 0.33333);

        renderVariableFaceRight(0, 0.66666);
        renderVariableTriangleRight(0.66666, 0.33333);

        renderVariableFrontFace(0.66666);

        bottomQuad();
        backQuad();
    }

    @Unique
    protected void renderSlopeB2() {
        renderVariableSlope(0.66666, 0.33333);

        renderVariableFaceLeft(0, 0.33333);
        renderVariableTriangleLeft(0.33333, 0.33333);

        renderVariableFaceRight(0, 0.33333);
        renderVariableTriangleRight(0.33333, 0.33333);

        renderVariableFrontFace(0.33333);

        bottomQuad();
        renderVariableBackFace(0.66666);
    }

    @Unique
    protected void renderSlopeB3() {
        renderVariableSlope(0.33333, 0);

        renderVariableTriangleLeft(0, 0.33333);

        renderVariableTriangleRight(0, 0.33333);

        bottomQuad();
        renderVariableBackFace(0.33333);
    }

    @Unique
    protected void renderSlopeC1() {
        renderVariableSlope(1, 0.75);

        renderVariableFaceLeft(0, 0.75);
        renderVariableTriangleLeft(0.75, 0.25);

        renderVariableFaceRight(0, 0.75);
        renderVariableTriangleRight(0.75, 0.25);

        renderVariableFrontFace(0.75);

        bottomQuad();
        backQuad();
    }

    @Unique
    protected void renderSlopeC2() {
        renderVariableSlope(0.75, 0.50);

        renderVariableFaceLeft(0, 0.50);
        renderVariableTriangleLeft(0.50, 0.25);

        renderVariableFaceRight(0, 0.50);
        renderVariableTriangleRight(0.50, 0.25);

        renderVariableFrontFace(0.50);

        bottomQuad();
        renderVariableBackFace(0.75);
    }

    @Unique
    protected void renderSlopeC3() {
        renderVariableSlope(0.50, 0.25);

        renderVariableFaceLeft(0, 0.25);
        renderVariableTriangleLeft(0.25, 0.25);

        renderVariableFaceRight(0, 0.25);
        renderVariableTriangleRight(0.25, 0.25);

        renderVariableFrontFace(0.25);

        bottomQuad();
        renderVariableBackFace(0.50);
    }

    @Unique
    protected void renderSlopeC4() {
        renderVariableSlope(0.25, 0);

        renderVariableTriangleLeft(0, 0.25);

        renderVariableTriangleRight(0, 0.25);

        bottomQuad();
        renderVariableBackFace(0.25);
    }

    // -------------------------------------------------------------------------------------

    @Unique
    protected void renderVariableSlope(double start, double end) {
        beginNegZSlope();
        // Front slope
        beginQuad();
        vertex(1, start, 1, 0, 0);
        vertex(1, end, 0, 0, 1);
        vertex(0, end, 0, 1, 1);
        vertex(0, start, 1, 1, 0);
        endFace();
    }

    @Unique
    protected void renderVariableTriangleLeft(double offset, double height) {
        beginPosXFace();
        beginTriangle();
        vertex(1, offset + height, 1, 0, 0);
        vertex(1, offset, 1, 0, 1 - height);
        vertex(1, offset, 0, 1, 1 - height);
        endFace();
    }

    @Unique
    protected void renderVariableTriangleRight(double offset, double height) {
        beginNegXFace();
        beginTriangle();
        vertex(0, offset + height, 1, 1, 0);
        vertex(0, offset, 0, 0, 1 - height);
        vertex(0, offset, 1, 1, 1 - height);
        endFace();
    }

    @SuppressWarnings("SameParameterValue")
    @Unique
    protected void renderVariableFaceLeft(double offset, double height) {
        beginNegXFace();
        beginQuad();
        vertex(0, offset + height, 0, 0, 1 - height);
        vertex(0, offset, 0, 0, 1);
        vertex(0, offset, 1, 1, 1);
        vertex(0, offset + height, 1, 1, 1 - height);
        endFace();
    }

    @SuppressWarnings("SameParameterValue")
    @Unique
    protected void renderVariableFaceRight(double offset, double height) {
        beginPosXFace();
        beginQuad();
        vertex(1, offset + height, 1, 0, 1 - height);
        vertex(1, offset, 1, 0, 1);
        vertex(1, offset, 0, 1, 1);
        vertex(1, offset + height, 0, 1, 1 - height);
        endFace();
    }

    @Unique
    protected void renderVariableFrontFace(double height) {
        beginNegZFace();
        beginQuad();
        vertex(1, height, 0, 0, 1 - height);
        vertex(1, 0, 0, 0, 1);
        vertex(0, 0, 0, 1, 1);
        vertex(0, height, 0, 1, 1 - height);
        endFace();
    }

    @Unique
    protected void renderVariableBackFace(double height) {
        beginPosZFace();
        beginQuad();
        vertex(0, height, 1, 0, 1 - height);
        vertex(0, 0, 1, 0, 1);
        vertex(1, 0, 1, 1, 1);
        vertex(1, height, 1, 1, 1 - height);
        endFace();
    }
}