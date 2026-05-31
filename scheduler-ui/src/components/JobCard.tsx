import type { Job } from "../types/job";

type Props = {
  job: Job;
  onEdit: (job: Job) => void;
  onDelete: (id: number) => void;
  onHistory: (id: number) => void;
};

export default function JobCard({
  job,
  onEdit,
  onDelete,
  onHistory,
}: Props) {
  return (
    <div className="bg-[#141414] border border-gray-800 rounded-lg p-3 text-sm hover:border-orange-500 transition">
      {/* HEADER */}
      <div className="flex justify-between">
        <span className="text-[10px] bg-green-500/20 text-green-400 px-2 py-0.5 rounded">
          {job.isActive ? "Aktif" : "Tidak Aktif"}
        </span>

        <div className="text-gray-400 text-xs flex gap-2">
          <button onClick={() => onEdit(job)}>✏️</button>
          <button onClick={() => onDelete(job.id)}>🗑️</button>
        </div>
      </div>

      {/* TITLE */}
      <h3 className="font-medium mt-2">{job.jobName}</h3>

      {/* DESCRIPTION */}
      <p className="text-gray-400 text-xs mt-1 line-clamp-2">
        {job.prompt}
      </p>

      {/* NEXT RUN */}
      <div className="bg-[#0d0d0d] mt-3 p-2 rounded border border-gray-700">
        <p className="text-orange-400 text-xs">
          {job.lastRunAt
            ? `Berikutnya: ${new Date(
                new Date(job.lastRunAt).getTime() + job.intervalSeconds * 1000
              ).toLocaleString()}`
            : "Belum pernah dijalankan"}
        </p>
      </div>

      {/* LAST RUN */}
      <p className="text-[10px] text-gray-500 mt-2">
        Terakhir: {job.lastRunAt ? new Date(job.lastRunAt).toLocaleString() : "-"}
      </p>

      {/* HISTORY */}
      <button
        className="text-orange-400 text-xs mt-1"
        onClick={() => onHistory(job.id)}
      >
        Lihat Riwayat →
      </button>
    </div>
  );
}