package com.extendedclip.papi.expansion.server;

import io.papermc.paper.threadedregions.RegionizedServer;
import io.papermc.paper.threadedregions.ThreadedRegionizer;
import io.papermc.paper.threadedregions.TickRegionScheduler;
import io.papermc.paper.threadedregions.TickRegions;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Arrays;
import java.util.List;

public class FoliaUtils {

    public List<Double> getGlobalTPS() {
        // Get region handle and check if there is already a cached tps for it
        final TickRegionScheduler.RegionScheduleHandle
                regionHandle = RegionizedServer.getGlobalTickData();

        double tps_5s =  regionHandle.getTickReport5s(System.nanoTime()).tpsData().segmentAll().average();
        double tps_15s =  regionHandle.getTickReport15s(System.nanoTime()).tpsData().segmentAll().average();
        double tps_1m =  regionHandle.getTickReport1m(System.nanoTime()).tpsData().segmentAll().average();
        double tps_5m =  regionHandle.getTickReport5m(System.nanoTime()).tpsData().segmentAll().average();
        double tps_15m =  regionHandle.getTickReport15m(System.nanoTime()).tpsData().segmentAll().average();

        return Arrays.asList(tps_5s, tps_15s, tps_1m, tps_5m, tps_15m);
    }

    public List<Double> getTPS(Location location) {
        if (location == null) return getGlobalTPS();

        World world = location.getWorld();
        if (world == null) return getGlobalTPS();
        // happens faster and on the thread of the region that owns the location.
        // Get the potential separate region that owns the location
        final ThreadedRegionizer.ThreadedRegion<TickRegions.TickRegionData, TickRegions.TickRegionSectionData>
                currentRegion = TickRegionScheduler.getCurrentRegion();
        // If not happening on a separate region, it must mean we're on the main region
        if (currentRegion == null) {
            return getGlobalTPS();
        }
        // Get region handle and check if there is already a cached tps for it
        final TickRegionScheduler.RegionScheduleHandle
                regionHandle = currentRegion.getData().getRegionSchedulingHandle();

        double tps_5s =  regionHandle.getTickReport5s(System.nanoTime()).tpsData().segmentAll().average();
        double tps_15s =  regionHandle.getTickReport15s(System.nanoTime()).tpsData().segmentAll().average();
        double tps_1m =  regionHandle.getTickReport1m(System.nanoTime()).tpsData().segmentAll().average();
        double tps_5m =  regionHandle.getTickReport5m(System.nanoTime()).tpsData().segmentAll().average();
        double tps_15m =  regionHandle.getTickReport15m(System.nanoTime()).tpsData().segmentAll().average();

        return Arrays.asList(tps_5s, tps_15s, tps_1m, tps_5m, tps_15m);
    }

    public List<Double> getGlobalMSPT() {
        // Get region handle and check if there is already a cached tps for it
        final TickRegionScheduler.RegionScheduleHandle
                regionHandle = RegionizedServer.getGlobalTickData();

        double mspt_5s =  regionHandle.getTickReport5s(System.nanoTime()).tpsData().segmentAll().average();
        double mspt_15s =  regionHandle.getTickReport15s(System.nanoTime()).tpsData().segmentAll().average();
        double mspt_1m =  regionHandle.getTickReport1m(System.nanoTime()).tpsData().segmentAll().average();
        double mspt_5m =  regionHandle.getTickReport5m(System.nanoTime()).tpsData().segmentAll().average();
        double mspt_15m =  regionHandle.getTickReport15m(System.nanoTime()).tpsData().segmentAll().average();

        return Arrays.asList(mspt_5s, mspt_15s, mspt_1m, mspt_5m, mspt_15m);
    }

    public List<Double> getMSPT(Location location) {
        if (location == null) return getGlobalMSPT();

        World world = location.getWorld();
        if (world == null) return getGlobalMSPT();
        // happens faster and on the thread of the region that owns the location.
        // Get the potential separate region that owns the location
        final ThreadedRegionizer.ThreadedRegion<TickRegions.TickRegionData, TickRegions.TickRegionSectionData>
                currentRegion = TickRegionScheduler.getCurrentRegion();
        // If not happening on a separate region, it must mean we're on the main region
        if (currentRegion == null) {
            return getGlobalMSPT();
        }
        // Get region handle and check if there is already a cached tps for it
        final TickRegionScheduler.RegionScheduleHandle
                regionHandle = currentRegion.getData().getRegionSchedulingHandle();

        double mspt_5s =  regionHandle.getTickReport5s(System.nanoTime()).timePerTickData().segmentAll().average();
        double mspt_15s =  regionHandle.getTickReport15s(System.nanoTime()).timePerTickData().segmentAll().average();
        double mspt_1m =  regionHandle.getTickReport1m(System.nanoTime()).timePerTickData().segmentAll().average();
        double mspt_5m =  regionHandle.getTickReport5m(System.nanoTime()).timePerTickData().segmentAll().average();
        double mspt_15m =  regionHandle.getTickReport15m(System.nanoTime()).timePerTickData().segmentAll().average();

        return Arrays.asList(mspt_5s, mspt_15s, mspt_1m, mspt_5m, mspt_15m);
    }
}
