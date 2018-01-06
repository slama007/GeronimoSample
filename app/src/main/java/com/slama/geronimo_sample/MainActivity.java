package com.slama.geronimo_sample;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.slama.geronimo_sample.adapter.SerieAdapter;
import com.slama.geronimo_sample.item.ItemSerie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private SerieAdapter adapter=null;
    private List<ItemSerie> seriesRandom = new ArrayList<>();
    private List<ItemSerie> series = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //fill the list of serie
        addSeries();

        //fill the list of Random serie to use with add button
        addSeriesRandom();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //defines the arrangement of the cells, here in a vertical way, as a ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // then create a SerieAdapter, provide it our series list.
        // this adapt will serve to fill our recyclerview
        adapter = new SerieAdapter(series);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        // add Action
        if (id == R.id.action_add) {

            Random r = new Random();
            int position = r.nextInt(5);
            SerieAdapter adapter = this.adapter;
            ItemSerie serie = seriesRandom.get(position);

            if (adapter.list != null && adapter.list.size() > 1) {
                adapter.list.add(1, serie);
                adapter.notifyItemInserted(1);
                return true;
            } else if (adapter.list == null) {
                return true;
            } else {
                adapter.list.add(serie);
                adapter.notifyItemInserted(0);
                return true;
            }
        }
        //remove action
        if (id == R.id.action_remove) {
            SerieAdapter adapter = this.adapter;
            if (adapter.list == null || adapter.list.isEmpty()) {
                return true;
            }
            adapter.list.remove(0);
            adapter.notifyItemRemoved(0);
            adapter.notifyItemRangeChanged(0,  adapter.list.size());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addSeries() {
        series.add(new ItemSerie("Vikings","Scandinavie, à la fin du 8ème siècle. Ragnar Lodbrok, un jeune guerrier viking, est avide d'aventures et de nouvelles conquêtes. Lassé des pillages sur les terres de l'Est, il se met en tête d'explorer l'Ouest par la mer. Malgré la réprobation de son chef, Haraldson, il se fie aux signes et à la volonté des dieux, en construisant une nouvelle génération de vaisseaux, plus légers et plus rapides...","http://www.eclypsia.com/public/upload/cke/Cinema-Series/Vikings.jpg"));
        series.add(new ItemSerie("Dexter","Brillant expert scientifique du service médico-légal de la police de Miami, Dexter Morgan est spécialisé dans l'analyse de prélèvements sanguins. Mais voilà, Dexter cache un terrible secret : il est également tueur en série. Un serial killer pas comme les autres, avec sa propre vision de la justice.","https://serieall.fr/img/show/dexter_w.jpg"));
        series.add(new ItemSerie("Game of Thrones","Dans un pays où l'été peut durer plusieurs années et l'hiver toute une vie, des forces sinistres et surnaturelles se pressent aux portes du Royaume des Sept Couronnes. Pendant ce temps, complots et rivalités se jouent sur le continent pour s'emparer du Trône de Fer, le symbole du pouvoir absolu.","http://images6.livreshebdo.fr/sites/default/files/assets/images/game_of_thrones_cast_wallpaper_1.jpeg"));
        series.add(new ItemSerie("Breaking Bad","Walter White, 50 ans, est professeur de chimie dans un lycée du Nouveau-Mexique. Pour subvenir aux besoins de Skyler, sa femme enceinte, et de Walt Junior, son fils handicapé, il est obligé de travailler doublement. Son quotidien déjà morose devient carrément noir lorsqu'il apprend qu'il est atteint d'un incurable cancer des poumons. Les médecins ne lui donnent pas plus de deux ans à vivre. Pour réunir rapidement beaucoup d'argent afin de mettre sa famille à l'abri, Walter ne voit plus qu'une solution : mettre ses connaissances en chimie à profit pour fabriquer et vendre du crystal meth, une drogue de synthèse qui rapporte beaucoup. Il propose à Jesse, un de ses anciens élèves devenu un petit dealer de seconde zone, de faire équipe avec lui. Le duo improvisé met en place un labo itinérant dans un vieux camping-car. Cette association inattendue va les entraîner dans une série de péripéties tant comiques que pathétiques.","http://www.lorhkan.com/wp-content/uploads/2014/01/Breaking-Bad-2.jpg"));
        series.add(new ItemSerie("Westworld","A Westworld, un parc d'attractions dernier cri, les visiteurs paient des fortunes pour revivre le frisson de la conquête de l'Ouest dans ce monde alternatif. Le programme est mis en péril lorsque quelques-uns des androïdes, créés pour donner l'illusion, se détraquent. Les clients sont-ils en danger ?","http://www.premiere.fr/sites/default/files/styles/premiere_article/public/thumbnails/image/westworld_hbo.jpeg"));
        series.add(new ItemSerie("Vikings","Scandinavie, à la fin du 8ème siècle. Ragnar Lodbrok, un jeune guerrier viking, est avide d'aventures et de nouvelles conquêtes. Lassé des pillages sur les terres de l'Est, il se met en tête d'explorer l'Ouest par la mer. Malgré la réprobation de son chef, Haraldson, il se fie aux signes et à la volonté des dieux, en construisant une nouvelle génération de vaisseaux, plus légers et plus rapides...","http://www.eclypsia.com/public/upload/cke/Cinema-Series/Vikings.jpg"));
        series.add(new ItemSerie("Dexter","Brillant expert scientifique du service médico-légal de la police de Miami, Dexter Morgan est spécialisé dans l'analyse de prélèvements sanguins. Mais voilà, Dexter cache un terrible secret : il est également tueur en série. Un serial killer pas comme les autres, avec sa propre vision de la justice.","https://serieall.fr/img/show/dexter_w.jpg"));
        series.add(new ItemSerie("Game of Thrones","Dans un pays où l'été peut durer plusieurs années et l'hiver toute une vie, des forces sinistres et surnaturelles se pressent aux portes du Royaume des Sept Couronnes. Pendant ce temps, complots et rivalités se jouent sur le continent pour s'emparer du Trône de Fer, le symbole du pouvoir absolu.","http://images6.livreshebdo.fr/sites/default/files/assets/images/game_of_thrones_cast_wallpaper_1.jpeg"));
        series.add(new ItemSerie("Breaking Bad","Walter White, 50 ans, est professeur de chimie dans un lycée du Nouveau-Mexique. Pour subvenir aux besoins de Skyler, sa femme enceinte, et de Walt Junior, son fils handicapé, il est obligé de travailler doublement. Son quotidien déjà morose devient carrément noir lorsqu'il apprend qu'il est atteint d'un incurable cancer des poumons. Les médecins ne lui donnent pas plus de deux ans à vivre. Pour réunir rapidement beaucoup d'argent afin de mettre sa famille à l'abri, Walter ne voit plus qu'une solution : mettre ses connaissances en chimie à profit pour fabriquer et vendre du crystal meth, une drogue de synthèse qui rapporte beaucoup. Il propose à Jesse, un de ses anciens élèves devenu un petit dealer de seconde zone, de faire équipe avec lui. Le duo improvisé met en place un labo itinérant dans un vieux camping-car. Cette association inattendue va les entraîner dans une série de péripéties tant comiques que pathétiques.","http://www.lorhkan.com/wp-content/uploads/2014/01/Breaking-Bad-2.jpg"));
        series.add(new ItemSerie("Westworld","A Westworld, un parc d'attractions dernier cri, les visiteurs paient des fortunes pour revivre le frisson de la conquête de l'Ouest dans ce monde alternatif. Le programme est mis en péril lorsque quelques-uns des androïdes, créés pour donner l'illusion, se détraquent. Les clients sont-ils en danger ?","http://www.premiere.fr/sites/default/files/styles/premiere_article/public/thumbnails/image/westworld_hbo.jpeg"));

    }

    private void addSeriesRandom() {
        seriesRandom.add(new ItemSerie("Vikings","Scandinavie, à la fin du 8ème siècle. Ragnar Lodbrok, un jeune guerrier viking, est avide d'aventures et de nouvelles conquêtes. Lassé des pillages sur les terres de l'Est, il se met en tête d'explorer l'Ouest par la mer. Malgré la réprobation de son chef, Haraldson, il se fie aux signes et à la volonté des dieux, en construisant une nouvelle génération de vaisseaux, plus légers et plus rapides...","http://www.eclypsia.com/public/upload/cke/Cinema-Series/Vikings.jpg"));
        seriesRandom.add(new ItemSerie("Dexter","Brillant expert scientifique du service médico-légal de la police de Miami, Dexter Morgan est spécialisé dans l'analyse de prélèvements sanguins. Mais voilà, Dexter cache un terrible secret : il est également tueur en série. Un serial killer pas comme les autres, avec sa propre vision de la justice.","https://serieall.fr/img/show/dexter_w.jpg"));
        seriesRandom.add(new ItemSerie("Game of Thrones","Dans un pays où l'été peut durer plusieurs années et l'hiver toute une vie, des forces sinistres et surnaturelles se pressent aux portes du Royaume des Sept Couronnes. Pendant ce temps, complots et rivalités se jouent sur le continent pour s'emparer du Trône de Fer, le symbole du pouvoir absolu.","http://images6.livreshebdo.fr/sites/default/files/assets/images/game_of_thrones_cast_wallpaper_1.jpeg"));
        seriesRandom.add(new ItemSerie("Breaking Bad","Walter White, 50 ans, est professeur de chimie dans un lycée du Nouveau-Mexique. Pour subvenir aux besoins de Skyler, sa femme enceinte, et de Walt Junior, son fils handicapé, il est obligé de travailler doublement. Son quotidien déjà morose devient carrément noir lorsqu'il apprend qu'il est atteint d'un incurable cancer des poumons. Les médecins ne lui donnent pas plus de deux ans à vivre. Pour réunir rapidement beaucoup d'argent afin de mettre sa famille à l'abri, Walter ne voit plus qu'une solution : mettre ses connaissances en chimie à profit pour fabriquer et vendre du crystal meth, une drogue de synthèse qui rapporte beaucoup. Il propose à Jesse, un de ses anciens élèves devenu un petit dealer de seconde zone, de faire équipe avec lui. Le duo improvisé met en place un labo itinérant dans un vieux camping-car. Cette association inattendue va les entraîner dans une série de péripéties tant comiques que pathétiques.","http://www.lorhkan.com/wp-content/uploads/2014/01/Breaking-Bad-2.jpg"));
        seriesRandom.add(new ItemSerie("Westworld","A Westworld, un parc d'attractions dernier cri, les visiteurs paient des fortunes pour revivre le frisson de la conquête de l'Ouest dans ce monde alternatif. Le programme est mis en péril lorsque quelques-uns des androïdes, créés pour donner l'illusion, se détraquent. Les clients sont-ils en danger ?","http://www.premiere.fr/sites/default/files/styles/premiere_article/public/thumbnails/image/westworld_hbo.jpeg"));
        seriesRandom.add(new ItemSerie("Dexter","Brillant expert scientifique du service médico-légal de la police de Miami, Dexter Morgan est spécialisé dans l'analyse de prélèvements sanguins. Mais voilà, Dexter cache un terrible secret : il est également tueur en série. Un serial killer pas comme les autres, avec sa propre vision de la justice.","https://serieall.fr/img/show/dexter_w.jpg"));

    }
}
