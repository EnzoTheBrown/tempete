package stormTP.operator;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import stormTP.core.Runner;
import stormTP.core.TortoiseManager;

import java.util.Map;

public class GiveRankBolt implements IRichBolt {
    private OutputCollector collector;
    public GiveRankBolt() {
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
    public void prepare(Map arg0, TopologyContext context, OutputCollector collector) {
        this.collector = collector;
    }

    @Override
    public void execute(Tuple t) {
        Runner n = (Runner) t.getValueByField("tortoise");
        TortoiseManager tortoiseManager = new TortoiseManager(5, "Candy-Lebrun");

        Runner runnerRank = tortoiseManager.computeRank(
                n.getId(),
                n.getTop(),
                n.getNom(),
                n.getNbDevant(),
                n.getNbDerriere(),
                n.getTotal()
        );
        collector.emit(new Values(runnerRank));
    }

    @Override
    public void cleanup() {

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("runnerRank"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
