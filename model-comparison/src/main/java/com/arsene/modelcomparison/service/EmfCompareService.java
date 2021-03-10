package com.arsene.modelcomparison.service;

import org.springframework.stereotype.Service;

@Service
public class EmfCompareService {
//    URI uri1 = URI.createFileURI(gridFileMediaService.getFilePath(art1));
//    URI uri2 = URI.createFileURI(gridFileMediaService.getFilePath(art2));
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
//    ResourceSet resourceSet1 = new ResourceSetImpl();
//    ResourceSet resourceSet2 = new ResourceSetImpl();
//		resourceSet1.getResource(uri1, true);
//		resourceSet2.getResource(uri2, true);
//    IComparisonScope scope = new DefaultComparisonScope(resourceSet1, resourceSet2, null);
//
//    int total = 0;
//		try {
//        Comparison comparisonDef = EMFCompare.builder().build().compare(scope);
//        List<Match> matchesDef = comparisonDef.getMatches();
//        int counterDef = 0;
//        for (Match match : matchesDef) {
//            List<Match> lm = Lists.newArrayList(match.getAllSubmatches());
//            total += lm.size();
//            for (Match match2 : lm) {
//                if (match2.getLeft() != null && match2.getRight() != null)
//                    counterDef++;
//            }
//            if (match.getLeft() != null && match.getRight() != null)
//                counterDef++;
//        }
//        SimilarityRelation smr = new SimilarityRelation();
//        smr.setFromArtifact(art1);
//        smr.setToArtifact(art2);
//        smr.setValue((counterDef * 1.0) / total);
//        relationRepository.save(smr);
//        return smr.getValue();
//    } catch (Exception e) {
//        SimilarityRelation smr = new SimilarityRelation();
//        smr.setFromArtifact(art1);
//        smr.setToArtifact(art2);
//        smr.setValue(0);
//        relationRepository.save(smr);
//        return 0;
//    }
}
