import { useEffect, useState } from "react";
import Sidebar from "./components/Sidebar";
import Header from "./components/Header";
import JobCard from "./components/JobCard";
import PreviewPanel from "./components/PreviewPanel";
import JobModal from "./components/JobModal";
import HistoryModal from "./components/HistoryModal";

import {
  getJobs,
  createJob,
  updateJob,
  deleteJob,
  getHistory,
} from "./api/jobApi";

export default function App() {
  const token = localStorage.getItem("token") || "";

  const [jobs, setJobs] = useState<any[]>([]);
  const [openModal, setOpenModal] = useState(false);
  const [editData, setEditData] = useState<any>(null);

  const [historyOpen, setHistoryOpen] = useState(false);
  const [historyData, setHistoryData] = useState([]);

  const loadJobs = () => {
    getJobs(token).then(setJobs);
  };

  useEffect(() => {
    loadJobs();
  }, []);

  // CREATE / UPDATE
  const handleSave = async (data: any) => {
    if (editData) {
      await updateJob(editData.id, data, token);
    } else {
      await createJob(data, token);
    }

    setOpenModal(false);
    setEditData(null);
    loadJobs();
  };

  // DELETE
  const handleDelete = async (id: number) => {
    if (!confirm("Yakin hapus?")) return;
    await deleteJob(id, token);
    loadJobs();
  };

  // EDIT
  const handleEdit = (job: any) => {
    setEditData(job);
    setOpenModal(true);
  };

  // HISTORY
  const handleHistory = async (id: number) => {
    const res = await getHistory(id, token);
    setHistoryData(res);
    setHistoryOpen(true);
  };
  

  return (
    <div className="flex h-screen w-screen bg-[#0a0a0a] text-white text-sm">
      <Sidebar />

      <div className="flex flex-1">
        <div className="flex-1 p-4">
          <Header onCreate={() => {
            setEditData(null);
            setOpenModal(true);
          }} />

          {/* <button
            className="mb-3 bg-orange-500 px-3 py-1 rounded text-xs"
            onClick={() => {
              setEditData(null);
              setOpenModal(true);
            }}
          >
            + Buat Tugas
          </button> */}

          <div className="grid grid-cols-2 gap-3">
            {jobs.map((job) => (
              <JobCard
                key={job.id}
                job={job}
                onEdit={handleEdit}
                onDelete={handleDelete}
                onHistory={handleHistory}
              />
            ))}
          </div>
        </div>

        {/* <PreviewPanel /> */}
      </div>

      <JobModal
        open={openModal}
        onClose={() => setOpenModal(false)}
        onSave={handleSave}
        initialData={editData}
      />

      <HistoryModal
        open={historyOpen}
        onClose={() => setHistoryOpen(false)}
        data={historyData}
      />
    </div>
  );
}