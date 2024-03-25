package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.COLLIDER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class Collider {

    public static void init() {
        Elements();
        HighEnergyPhysics();
    }

    private static void Elements() {

        //  Cu + Cs -> Ac
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Copper.getFluid(L))
                .fluidInputs(Caesium.getFluid(L))
                .fluidOutputs(Actinium.getFluid(L))
                .fluidOutputs(FreeElectronGas.getFluid(L))
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Bi + alpha -> At
        COLLIDER_RECIPES.recipeBuilder()
                .input(ALPHA_PARTICLE)
                .fluidInputs(Bismuth.getFluid(L))
                .fluidOutputs(Astatine.getFluid(L))
                .EUt(VA[ZPM])
                .duration(180)
                .CasingTier(1)
                .buildAndRegister();

        //  C + At -> Ac
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Astatine.getFluid(L))
                .fluidInputs(Carbon.getFluid(L * 4))
                .fluidOutputs(Actinium.getFluid(L * 3))
                .fluidOutputs(FreeElectronGas.getFluid(L * 2))
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(2)
                .buildAndRegister();

        //  C + Cs -> La
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Caesium.getFluid(L))
                .fluidInputs(Carbon.getFluid(L * 4))
                .fluidOutputs(Lanthanum.getFluid(L))
                .fluidOutputs(FreeElectronGas.getFluid(L * 4))
                .EUt(VA[LuV])
                .duration(200)
                .CasingTier(2)
                .buildAndRegister();

        //  La + Li -> Ce
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Lanthanum.getFluid(L))
                .fluidInputs(Lithium.getFluid(L * 4))
                .fluidOutputs(Cerium.getFluid(L * 3))
                .fluidOutputs(FreeElectronGas.getFluid(L * 2))
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Cu + Sr -> Nb
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Strontium.getFluid(L))
                .fluidInputs(Copper.getFluid(L * 4))
                .fluidOutputs(Niobium.getFluid(L * 2))
                .fluidOutputs(FreeElectronGas.getFluid(L * 3))
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Be + Ce -> Nb
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Beryllium.getFluid(L * 6))
                .fluidInputs(Cerium.getFluid(L * 2))
                .fluidOutputs(Niobium.getFluid(L * 4))
                .fluidOutputs(FreeElectronGas.getFluid(L * 4))
                .EUt(VA[LuV])
                .duration(200)
                .CasingTier(2)
                .buildAndRegister();

        //  Pu-239 + alpha -> Cm
        COLLIDER_RECIPES.recipeBuilder()
                .input(ALPHA_PARTICLE)
                .fluidInputs(Plutonium239.getFluid(L))
                .fluidOutputs(Curium.getFluid(L))
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Bk + alpha -> Cf
        COLLIDER_RECIPES.recipeBuilder()
                .input(ALPHA_PARTICLE)
                .fluidInputs(Berkelium.getFluid(L * 2))
                .fluidOutputs(Californium.getFluid(L * 2))
                .EUt(VA[LuV])
                .duration(120)
                .CasingTier(1)
                .buildAndRegister();

        //  U-238 + alpha -> Neptunium
        COLLIDER_RECIPES.recipeBuilder()
                .input(ALPHA_PARTICLE)
                .fluidInputs(Uranium238.getFluid(L))
                .fluidOutputs(Neptunium.getFluid(L))
                .EUt(VA[ZPM])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Cm + alpha -> Bk
        COLLIDER_RECIPES.recipeBuilder()
                .input(ALPHA_PARTICLE)
                .fluidInputs(Curium.getFluid(L))
                .fluidOutputs(Berkelium.getFluid(L))
                .EUt(VA[LuV])
                .duration(140)
                .CasingTier(1)
                .buildAndRegister();

        //  C + Am -> Es
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Carbon.getFluid(L))
                .fluidInputs(Americium.getFluid(L))
                .fluidOutputs(Einsteinium.getFluid(L))
                .EUt(VA[UV])
                .duration(70)
                .CasingTier(2)
                .buildAndRegister();

        //  O + U-238 -> Fm
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getPlasma(L))
                .fluidInputs(Uranium238.getFluid(L))
                .fluidOutputs(Fermium.getFluid(L))
                .EUt(VA[ZPM])
                .duration(120)
                .CasingTier(1)
                .buildAndRegister();

        //  Es + He -> Md
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Einsteinium.getFluid(L))
                .fluidInputs(Helium.getPlasma(L))
                .fluidOutputs(Mendelevium.getFluid(L))
                .EUt(VA[UHV])
                .duration(240)
                .CasingTier(3)
                .buildAndRegister();

        //  C + Cm -> No
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Carbon.getFluid(L))
                .fluidInputs(Curium.getFluid(L))
                .fluidOutputs(Nobelium.getFluid(L))
                .EUt(VA[UHV])
                .duration(190)
                .CasingTier(3)
                .buildAndRegister();

        //  B + Cf -> Lr
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Boron.getFluid(L))
                .fluidInputs(Californium.getFluid(L))
                .fluidOutputs(Lawrencium.getFluid(L))
                .EUt(VA[UHV])
                .duration(200)
                .CasingTier(3)
                .buildAndRegister();

        //  Ichorium -> Void Metal
        COLLIDER_RECIPES.recipeBuilder()
                .notConsumable(QUANTUM_ANOMALY)
                .fluidInputs(Ichorium.getFluid(L))
                .fluidOutputs(VoidMetal.getFluid(L))
                .EUt(VA[UV])
                .duration(120)
                .CasingTier(2)
                .buildAndRegister();

    }

    private static void HighEnergyPhysics() {

        //  Helium Plasma:
        //    Gluon (1.6%), Photon (2.6%), Z Boson (1.5%), W Boson (1.5%), Higgs Boson (0.01%)
        COLLIDER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Helium.getPlasma(3000))
                .chancedOutput(GLUON, 160, 0)
                .chancedOutput(PHOTON, 260, 0)
                .chancedOutput(Z_BOSON, 150, 0)
                .chancedOutput(W_BOSON, 150, 0)
                .chancedOutput(HIGGS_BOSON, 1, 0)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(2) // UV
                .buildAndRegister();

        //  Gluons:
        //    Gluon (16%), Photon (26%), Z Boson (15%), W Boson (15%), Higgs Boson (1%)
        COLLIDER_RECIPES.recipeBuilder()
                .circuitMeta(11)
                .fluidInputs(Gluons.getFluid(3000))
                .chancedOutput(GLUON, 1600, 0)
                .chancedOutput(PHOTON, 2600, 0)
                .chancedOutput(Z_BOSON, 1500, 0)
                .chancedOutput(W_BOSON, 1500, 0)
                .chancedOutput(HIGGS_BOSON, 100, 0)
                .EUt(VA[UHV])
                .duration(200)
                .CasingTier(3) // UHV
                .buildAndRegister();

        //  Free Electron Gas:
        //    Electron (6%), Muon (0.4%), Tau (0.2%), Electron Neutrino (0.15%), Muon Neutrino (0.1%), Tau Neutrino (0.05%)
        COLLIDER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(FreeElectronGas.getFluid(1000))
                .chancedOutput(ELECTRON, 600, 0)
                .chancedOutput(MUON, 40, 0)
                .chancedOutput(TAU, 20, 0)
                .chancedOutput(ELECTRON_NEUTRINO, 15, 0)
                .chancedOutput(MUON_NEUTRINO, 10, 0)
                .chancedOutput(TAU_NEUTRINO, 5, 0)
                .EUt(VA[ZPM])
                .duration(300)
                .CasingTier(1) // ZPM
                .buildAndRegister();

        //  Heavy Lepton Mixture:
        //    Electron (60%), Muon (4%), Tau (2%), Electron Neutrino (1.5%), Muon Neutrino (1%), Tau Neutrino (0.5%)
        COLLIDER_RECIPES.recipeBuilder()
                .circuitMeta(12)
                .fluidInputs(HeavyLepton.getFluid(1000))
                .chancedOutput(ELECTRON, 6000, 0)
                .chancedOutput(MUON, 400, 0)
                .chancedOutput(TAU, 200, 0)
                .chancedOutput(ELECTRON_NEUTRINO, 150, 0)
                .chancedOutput(MUON_NEUTRINO, 100, 0)
                .chancedOutput(TAU_NEUTRINO, 50, 0)
                .EUt(VA[UV])
                .duration(150)
                .CasingTier(2) // UV
                .buildAndRegister();

        //  Argon Plasma:
        //    Up Quark (0.5%), Down Quark (0.5%), Charm Quark (0.5%), Strange Quark (0.5%), Top Quark (0.5%), Bottom Quark (0.5%)
        COLLIDER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .fluidInputs(Argon.getPlasma(100))
                .chancedOutput(UP_QUARK, 50, 0)
                .chancedOutput(DOWN_QUARK, 50, 0)
                .chancedOutput(CHARM_QUARK, 50, 0)
                .chancedOutput(STRANGE_QUARK, 50, 0)
                .chancedOutput(TOP_QUARK, 50, 0)
                .chancedOutput(BOTTOM_QUARK, 50, 0)
                .EUt(VA[UEV])
                .duration(700)
                .CasingTier(4) // UEV
                .buildAndRegister();

        //  Temporal Fluid:
        //    Up Quark (5%), Down Quark (5%), Charm Quark (5%), Strange Quark (5%), Top Quark (5%), Bottom Quark (5%)
        COLLIDER_RECIPES.recipeBuilder()
                .circuitMeta(13)
                .fluidInputs(TemporalFluid.getFluid(100))
                .chancedOutput(UP_QUARK, 500, 0)
                .chancedOutput(DOWN_QUARK, 500, 0)
                .chancedOutput(CHARM_QUARK, 500, 0)
                .chancedOutput(STRANGE_QUARK, 500, 0)
                .chancedOutput(TOP_QUARK, 500, 0)
                .chancedOutput(BOTTOM_QUARK, 500, 0)
                .EUt(VA[UIV])
                .duration(350)
                .CasingTier(5) // UIV
                .buildAndRegister();

        //  Americium Plasma:
        //    Graviton (0.5%), Eta-Meson (0.5%), Meson (0.5%), Proton (0.4%), Neutron (0.3%), Higgs Boson (0.1%)
        COLLIDER_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .fluidInputs(Americium.getPlasma(2500))
                .chancedOutput(GRAVITON, 50, 0)
                .chancedOutput(ETA_MESON, 50, 0)
                .chancedOutput(MESON, 50, 0)
                .chancedOutput(PROTON, 40, 0)
                .chancedOutput(NEUTRON, 30, 0)
                .chancedOutput(HIGGS_BOSON, 10, 0)
                .EUt(VA[UHV])
                .duration(500)
                .CasingTier(3) // UHV
                .buildAndRegister();

        //  Taranium Plasma:
        //    Graviton (5%), Eta-Meson (5%), Meson (5%), Proton (4%), Neutron (3%), Higgs Boson (1%)
        COLLIDER_RECIPES.recipeBuilder()
                .circuitMeta(14)
                .fluidInputs(Taranium.getPlasma(2500))
                .chancedOutput(GRAVITON, 500, 0)
                .chancedOutput(ETA_MESON, 500, 0)
                .chancedOutput(MESON, 500, 0)
                .chancedOutput(PROTON, 400, 0)
                .chancedOutput(NEUTRON, 300, 0)
                .chancedOutput(HIGGS_BOSON, 100, 0)
                .EUt(VA[UEV])
                .duration(250)
                .CasingTier(4) // UEV
                .buildAndRegister();

        //  Nitrogen Plasma:
        //    Proton (1.25%), Neutron (1.25%), Electron (1.25%), Lambda-Baryon (0.2%), Omega-Baryon (0.2%)
        COLLIDER_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .fluidInputs(Nitrogen.getPlasma(600))
                .chancedOutput(PROTON, 125, 0)
                .chancedOutput(NEUTRON, 125, 0)
                .chancedOutput(ELECTRON, 125, 0)
                .chancedOutput(LAMBDA_BARYON, 20, 0)
                .chancedOutput(OMEGA_BARYON, 20, 0)
                .EUt(VA[ZPM])
                .duration(400)
                .CasingTier(1) // ZPM
                .buildAndRegister();

        //  Adamantium Plasma:
        //    Proton (12.5%), Neutron (12.5%), Electron (12.5%), Lambda-Baryon (2%), Omega-Baryon (2%)
        COLLIDER_RECIPES.recipeBuilder()
                .circuitMeta(15)
                .fluidInputs(Adamantium.getPlasma(600))
                .chancedOutput(PROTON, 1250, 0)
                .chancedOutput(NEUTRON, 1250, 0)
                .chancedOutput(ELECTRON, 1250, 0)
                .chancedOutput(LAMBDA_BARYON, 200, 0)
                .chancedOutput(OMEGA_BARYON, 200, 0)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(2) // UV
                .buildAndRegister();

        //  Free Electron Gas -> Quantum Anomaly
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(FreeElectronGas.getFluid(L))
                .chancedOutput(QUANTUM_ANOMALY, 1000, 0)
                .EUt(VA[ZPM])
                .duration(200)
                .CasingTier(1) // ZPM
                .buildAndRegister();

        //  Electron -> Quantum Anomaly
        COLLIDER_RECIPES.recipeBuilder()
                .input(ELECTRON)
                .chancedOutput(QUANTUM_ANOMALY, 1000, 0)
                .EUt(VA[UV])
                .duration(100)
                .CasingTier(2) // UV
                .buildAndRegister();

    }
}
