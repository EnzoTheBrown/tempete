package stormTP.operator;

import org.apache.storm.state.State;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.IStatefulBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseWindowedBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.apache.storm.windowing.TupleWindow;
import stormTP.core.Runner;
import stormTP.core.TortoiseManager;

import java.util.Map;

public class ComputeBonusBolt extends BaseWindowedBolt{


    @Override
    public void execute(TupleWindow tupleWindow) {
        TortoiseManager tortoiseManager = new TortoiseManager(5, "Candy-Lebrun");
        Runner runner = null;
        // getting the last runner position of the window
        for(Tuple tuple : tupleWindow.get()){
            runner = (Runner) tuple.getValueByField("tortoise");
        }

        runner.setPoints(tortoiseManager.computePoints(runner.getRang(), runner.getTotal()) + runner.getPoints());

        collector.emit(new Values(runner));
    }


    private OutputCollector collector;
    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector){
        this.collector = collector;
    }
}
