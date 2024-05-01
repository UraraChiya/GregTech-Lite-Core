package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.unification.material.Material;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

/**
 * Third Degree Materials
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is a part of {@code Material} class.
 * </p>
 *
 * @since 2.8.7-beta
 */
public class GTLiteThirdDegreeMaterials {

    //  Range: 20001-21000
    private static int startId = 20001;
    private static final int endId = startId + 999;

    public static void register() {

        //  20001 Proto Adamantium
        ProtoAdamantium = new Material.Builder(getId(), gregtechId("proto_adamantium"))
                .dust()
                .ore(1, 1, true)
                .addOreByproducts(Adamantite)
                .color(0xAA0D0D)
                .iconSet(SHINY)
                .components(Adamantium, 3, Promethium, 2)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .build();

        //  20002 Enriched Mithril
        EnrichedMithril = new Material.Builder(getId(), gregtechId("enriched_mithril"))
                .dust()
                .ore(1, 1, true)
                .addOreByproducts(Mithril)
                .color(0x2B45DF)
                .iconSet(SHINY)
                .components(Mithril, 2, NaquadahEnriched, 1, Oxygen, 14)
                .build();

        //  20003 Trinium Titanide
        TriniumTitanide = new Material.Builder(getId(), gregtechId("trinium_titanide"))
                .dust()
                .ore(1, 1, false)
                .addOreByproducts(Trinium)
                .color(0x9986A3)
                .iconSet(SHINY)
                .components(Trinium, 2, Titanium, 1)
                .build();

        //  20004 Germanium Tungsten Nitride
        GermaniumTungstenNitride = new Material.Builder(getId(), gregtechId("germanium_tungsten_nitride"))
                .dust()
                .ore(1, 1, false)
                .addOreByproducts(Germanium)
                .color(0x8F8FCF)
                .iconSet(METALLIC)
                .components(Germanium, 3, Tungsten, 3, Nitrogen, 10)
                .build();

        //  20005 Bismuth Iridiate
        BismuthIridiate = new Material.Builder(getId(), gregtechId("bismuth_iridiate"))
                .dust()
                .ore(1,1, false)
                .addOreByproducts(Iridium)
                .color(0x478A6B)
                .iconSet(DULL)
                .components(Bismuth, 2, Iridium, 2, Oxygen, 7)
                .build();

        //  20006 Bismuth Ruthenate
        BismuthRuthenate = new Material.Builder(getId(), gregtechId("bismuth_ruthenate"))
                .dust()
                .ore(1, 1, false)
                .addOreByproducts(Ruthenium)
                .color(0x94CF5C)
                .iconSet(DULL)
                .components(Bismuth, 2, Ruthenium, 2, Oxygen, 7)
                .build();

        //  20007 Sylvanite
        Sylvanite = new Material.Builder(getId(), gregtechId("sylvanite"))
                .dust()
                .ore(2, 2, false)
                .addOreByproducts(Electrum)
                .color(0xE4EBDC)
                .iconSet(METALLIC)
                .components(Gold, 1, Silver, 1, Tellurium, 4)
                .build();

        //  20008 Rheniite
        Rheniite = new Material.Builder(getId(), gregtechId("rheniite"))
                .dust()
                .ore(1, 2, false)
                .addOreByproducts(Rhenium)
                .color(0xDFDFDF)
                .iconSet(SHINY)
                .components(Rhenium, 1, Sulfur, 2)
                .build();

        //  20009 Gadolinite
        Gadolinite = new Material.Builder(getId(), gregtechId("gadolinite"))
                .dust()
                .ore(1, 1, false)
                .addOreByproducts(Yttrium)
                .addOreByproducts(Holmium)
                .color(0xB52F2A)
                .iconSet(ROUGH)
                .components(Yttrium, 2, Iron, 1, Beryllium, 2, Silicon, 2, Oxygen, 10)
                .build()
                .setFormula("Y2FeBe2(SiO4)2O2", true);

        //  20010 Euxenite
        Euxenite = new Material.Builder(getId(), gregtechId("euxenite"))
                .dust()
                .ore(2, 1, false)
                .addOreByproducts(Thorium)
                .addOreByproducts(Lutetium)
                .color(0x0D6330)
                .iconSet(DULL)
                .components(Cerium, 1, Tantalum, 2, Oxygen, 6)
                .build();

        //  20011 Platarsite
        Platarsite = new Material.Builder(getId(), gregtechId("platarsite"))
                .dust()
                .ore(3, 2, false)
                .addOreByproducts(Rhodium)
                .addOreByproducts(Tellurium)
                .color(0x77055B)
                .iconSet(METALLIC)
                .components(Platinum, 1, Arsenic, 1, Sulfur, 1)
                .build();

        //  20012 Picotite
        Picotite = new Material.Builder(getId(), gregtechId("picotite"))
                .gem(3)
                .ore(2, 3, false)
                .addOreByproducts(Magnesium)
                .addOreByproducts(Aluminium)
                .color(0x931C24)
                .iconSet(DIAMOND)
                .components(Iron, 1, Chrome, 2, Oxygen, 4)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
