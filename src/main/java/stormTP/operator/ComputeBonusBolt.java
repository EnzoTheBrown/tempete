package stormTP.operator;

import org.apache.storm.state.State;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.IStatefulBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import stormTP.core.Runner;
import stormTP.core.TortoiseManager;

import java.util.Map;

public class ComputeBonusBolt implements IStatefulBolt{

    private OutputCollector collector;
    @Override
    public void execute(Tuple t) {
        Runner runner = (Runner) t.getValueByField("tortoise");
        
        TortoiseManager tortoiseManager = new TortoiseManager(5, "Candy-Lebrun");
        // updating old score
        runner.setPoints(tortoiseManager.computePoints(runner.getRang(), runner.getTotal()) + runner.getPoints());
        collector.emit(new Values(runner));
    }


    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("tortoise"));
    }

    public ComputeBonusBolt() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {

    }

    @Override
    public void cleanup() {

    }

    @Override
    public void initState(State state) {

    }

    @Override
    public void preCommit(long l) {

    }

    @Override
    public void prePrepare(long l) {

    }

    @Override
    public void preRollback() {

    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
